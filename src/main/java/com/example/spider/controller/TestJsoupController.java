package com.example.spider.controller;

import com.example.spider.dal.result.Result;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestJsoupController {
    @RequestMapping ("/hello")
    public Result queryMonitor() {
        String url = "https://www.baidu.com/";
        String cookie = "BIDUPSID=A75D9A3841AF791B72F84700F446B734; PSTM=1603460200; __yjs_duid=1_1d88573185374d644376db288a861d511619574457002; H_WISE_SIDS=107318_110085_127969_128698_175755_176398_176678_177008_177407_177473_177755_177989_178026_178328_178625_179259_179350_179402_179458_179520_180123_180181_180276_180324_180364_180407_180513_180617_180654_180676_180699_180751_180755_180757_180822_180870_180890_180915_180932_180983_181259_181329_181426_181432_181446_181488_181610_181648_181661_181942_182077; MCITY=-%3A; BDUSS=HR1WXlramp3alZ1RURZNnZ3S1o5YzhQaVZkT2dFZDV1Q01RbXVycUw1RENpYjFoRVFBQUFBJCQAAAAAAAAAAAEAAAB1yfznAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAML8lWHC~JVhc; BDUSS_BFESS=HR1WXlramp3alZ1RURZNnZ3S1o5YzhQaVZkT2dFZDV1Q01RbXVycUw1RENpYjFoRVFBQUFBJCQAAAAAAAAAAAEAAAB1yfznAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAML8lWHC~JVhc; BAIDUID=805D26C09AA3D41DA6E03EF68D96587B:SL=0:NR=10:FG=1; H_WISE_SIDS_BFESS=107318_110085_127969_128698_175755_176398_176678_177008_177407_177473_177755_177989_178026_178328_178625_179259_179350_179402_179458_179520_180123_180181_180276_180324_180364_180407_180513_180617_180654_180676_180699_180751_180755_180757_180822_180870_180890_180915_180932_180983_181259_181329_181426_181432_181446_181488_181610_181648_181661_181942_182077; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDSFRCVID=vsuOJeC62ZgrjtcDFQNtKAKChstS1c3TH6f3RTvLb0fPbnS1_33TEG0PDf8g0KubMVkPogKKLgOTHULF_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tbFJoD-MtCvbfP0k-PnVh-_Hqxby26nBMHO9aJ5nJDoTJlK6hMnUQl_NX-RCBMJ32jcpob0KQpP-HJ7aKxT53qT0QHjPBtRRaeKqKl0MLInWbb0xyn_Vb4cD0UnMBMnr52OnaU513fAKftnOM46JehL3346-35543bRTLnLy5KJtMDF4j585DjJWDHRBKR3a-D60Wt88Kb7VKROkenj55f4pbt-qJqTM-DQJ3hbILlrMOpjoLP755hJL-NbnBT5htarnLqRttnQmHRrbDqP5Dp0kQN3T0PKO5bRiLRozQJvmDn3oyUvJXp0n3tvly5jtMgOBBJ0yQ4b4OR5JjxonDh83bG7MJUutfD7H3KC2JCtahUK; BDSFRCVID_BFESS=vsuOJeC62ZgrjtcDFQNtKAKChstS1c3TH6f3RTvLb0fPbnS1_33TEG0PDf8g0KubMVkPogKKLgOTHULF_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF_BFESS=tbFJoD-MtCvbfP0k-PnVh-_Hqxby26nBMHO9aJ5nJDoTJlK6hMnUQl_NX-RCBMJ32jcpob0KQpP-HJ7aKxT53qT0QHjPBtRRaeKqKl0MLInWbb0xyn_Vb4cD0UnMBMnr52OnaU513fAKftnOM46JehL3346-35543bRTLnLy5KJtMDF4j585DjJWDHRBKR3a-D60Wt88Kb7VKROkenj55f4pbt-qJqTM-DQJ3hbILlrMOpjoLP755hJL-NbnBT5htarnLqRttnQmHRrbDqP5Dp0kQN3T0PKO5bRiLRozQJvmDn3oyUvJXp0n3tvly5jtMgOBBJ0yQ4b4OR5JjxonDh83bG7MJUutfD7H3KC2JCtahUK; H_PS_PSSID=36828_36553_36752_36824_36455_36414_36690_36167_36816_36777_36775_36637_36744_36763_36768_36764_26350_36862_36713; BA_HECTOR=05ah2h012k2g210l8l23651i1hd22hv16; ZFY=82brrD9JRZCM3SptneubaT5OAem3XL5jRyhXn50yInQ:C; BAIDUID_BFESS=805D26C09AA3D41DA6E03EF68D96587B:SL=0:NR=10:FG=1";
        return getWebPageWithCookies(url,cookie);
    }


    public Result getWebPageWithCookies(String url,String cookies) {
        HashMap<String, String> hashMap = cookiesTransform(cookies);
        //获取爬取网页的信息
        try {
            Document doc = Jsoup.connect(url).cookies(hashMap).get();
            return Result.of(doc.text());
        }catch (Exception e){
            String exceptionMessage = e.getMessage();
            return Result.fail(500,exceptionMessage);
        }
    }


    public HashMap<String, String> cookiesTransform(String cookies) {
        HashMap<String, String> cookiesMap = new HashMap<>();
        String[] items = cookies.trim().split(";");
        for (String item : items) {
            cookiesMap.put(item.split("=")[0], item.split("=")[1]);
        }
        return cookiesMap;
    }


    @RequestMapping ("/douban")
    public static void printMovieName() throws IOException {

        // 豆瓣电影Top250
        String url = "https://movie.douban.com/top250";

        // 获取页面
        Document document = Jsoup.connect(url).get();

        // 根据class获取元素集合
        Elements titles = document.getElementsByClass("title");
        int index = 1;
        for (Element title : titles) {
            String text = title.text();
            // 过滤掉电影的其他名称
            if (!text.contains("/")) {
                System.out.println("No." + index + " " + text);
                index++;
            }
        }
    }
}

