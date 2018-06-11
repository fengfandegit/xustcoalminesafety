package com.xust.controller;

import com.xust.dao.AverageDao;
import com.xust.service.ReadRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2018/5/30.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/readdata")
public class ReadDataController {
    @Autowired
    ReadRunService readRunService;

    /*@PostMapping("/gethistorydata")*/
    @RequestMapping("/gethistorydata")
    public Object getData(@RequestParam("callback") String callback,
                          @RequestParam("no") String no,
                          @RequestParam("type") String type,
                          @RequestParam("id") String id,
                          @RequestParam("starttime") String starttime,
                          @RequestParam("endtime") String endtime,
                          @RequestParam("black") String black) {
        Map<String, AverageDao[]> map = readRunService.getData(no, type, id, starttime, endtime, black, true);
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        String prekey = "";
        while (it.hasNext()) {
            String key = it.next();
            if ("1".equals(key.split("_")[1])) {
                prekey = key;
            }
        }

        map.put("pre" + prekey, readRunService.getNowPre(map.get(prekey)));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(map);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping("/getnowdata")
    public Object getData(@RequestParam("no") String no,
                          @RequestParam("type") String type,
                          @RequestParam("id") String id,
                          @RequestParam("callback") String callback) {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String valuem = sdf.format(d);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(readRunService.getNowDatas(no, type, id, valuem));
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping("/getzhan")
    public Object getZhan(@RequestParam("callback") String callback) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(readRunService.getAboutZhan());
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping(value = "/upload", consumes = "multipart/form-data", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                /*
                 * 这段代码执行完毕之后，图片上传到了工程的跟路径； 大家自己扩散下思维，如果我们想把图片上传到
                 * d:/files大家是否能实现呢？ 等等;
                 * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如： 1、文件路径； 2、文件名；
                 * 3、文件格式; 4、文件大小的限制;
                 */
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                file.getOriginalFilename())));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return "上传成功";

        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
