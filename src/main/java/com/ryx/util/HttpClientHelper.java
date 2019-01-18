package com.ryx.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;




public class HttpClientHelper {


    public static void main(String[] args) {
String url="http://www.jieqianyong.com.cn:8081/loanSix/user/selectUsers.do?currentPage=1&showCount=100";
        String result=sendPost(url, null, "UTF-8");
      Document document= Jsoup.parse(result);
       Elements tbodyElement=document.getElementsByTag("tbody");
        Element trElement=  tbodyElement.get(1);
        Elements trElements=trElement.getElementsByTag("tr");
        for (int i=0;i<trElements.size();i++){
           Element element= trElements.get(i);
            Elements tdlies=element.getElementsByTag("td");
            Element element1=tdlies.get(1);

            Element element2=tdlies.get(2);
            Element element3=tdlies.get(3);
            Element element4=tdlies.get(4);
            Element element5=tdlies.get(5);
            Element element6=tdlies.get(6);
            System.out.println(element1.text()+","+element2.text()+","+element3.text()+","+element4.text()+","+element5.text()+","+element6.text()+",");

        }

    }

//    public static void main(String[] args) {
////		 BlockingQueue blockingQueue=new ArrayBlockingQueue<Object>(10);
////
////	     ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(20, 20, 10, TimeUnit.MINUTES, blockingQueue);
////
////	     for(int i=0;i<20;i++)
////	        {
////	            Runnable runnable=new Runnable() {
////					@Override
////					public void run() {
////						// TODO Auto-generated method stub
////						postTouPiao();
////					}
////				};
////	            threadPoolExecutor.submit(runnable);
////	        }
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for(int i=0;i<3000;i++){
//                    postTouPiao(i);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for(int i=3000;i<6000;i++){
//                    postTouPiao(i);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for(int i=6000;i<8000;i++){
//                    postTouPiao(i);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                for(int i=8000;i<10000;i++){
//                    postTouPiao(i);
//                }
//            }
//        }).start();
//    }

    private static void postTouPiao(int i){
        String code="";
        int codeLength=String.valueOf(i).length();
        if(codeLength==1){
            code="000"+i;
        }else if(codeLength==2){
            code="00"+i;
        }else if(codeLength==3){
            code="0"+i;
        }else{
            code=i+"";
        }
        String url="http://hd.ldcloud.cc/hd_CNhOXk6gtM?i=3&c=entry&op=edit&do=login&m=ldy_platform&mobile=18678871185&pwd1=123456&pwd2=123456&type=1&code="+code;
//		String url="http://sypm.wx.yiyao365.cn/index.php?g=Wap&m=Voteimg&a=vote&vote_id=64&token=vjaevb1429686452&pid=1&id="+a+"&wecha_id=oKfTMjtFk4"+val21+"9M-kCExH10c"+val22+val23;
//		String url="http://www.paihang360.com/mzt/jujiao2018/pppinfo.jsp?record_id=153003&op=op_submit";
        Map<String,Object> params=new HashMap();
//		String url="http://angaod1.liankechuanmei111.cn/wxshop/Ballot/Ix8CK0Y?hdid=0ab710ac-e9a7-4740-a8f6-0285ea606fcf&id=bf2e853f-6590-46bd-945f-c28643d01d3c&type=People&t=1520982278326&codeClean=0117uTkN0Uoeg52WDZkN0LXHkN07uTk-&stateClean=angaod&jump=jump";
//		String url="http://angaod1.liankechuanmei111.cn/wxshop/web/aipainew/aipainewAction!login.action?t=&id=bf2e853f-6590-46bd-945f-c28643d01d3c";
        String result=sendPost(url, params, "GBK");
        if(result.contains("200")){
            System.out.println("验证码"+code);
            String a=null;
            a.length();
        }else{
            System.out.println("次数=="+code+result);
        }
    }

//		int start=result.indexOf(">济南");
//		if(start>0){
//			int xingmingks=result.indexOf("*");
//			int xingmingend=result.indexOf("</td></tr><tr><td>地址");
//			int end=result.indexOf("</td></tr><tr><td>欠");
//			String xingming=result.subSequence(xingmingks, xingmingend).toString();
//					String zhuzhi=result.subSequence(start+1, end).toString();
//					String msg="燃气号:"+cxcode+";姓名:"+xingming+";住址:"+zhuzhi;
//					writeToFile1(msg);
//			System.out.println(msg);
//		}
//		postTouPiao();

    public static  void writeToFile1(String msg){

        try {
            File file = new File("F:/text/text.txt");
            if(file.exists()){
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(msg);
                fw.write("\r\n");
                bw.close();
                fw.close();
                System.out.println("test1 done!");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * @Description:使用HttpURLConnection发送post请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:26:07
     */
    public static String sendPost(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        // 发送请求
        try {
            URL url = new URL(urlParam);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
//            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//            con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
//            con.setRequestProperty("Accept-Encoding", "gzip, deflate");
//            con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-us;q=0.6,en;q=0.5;q=0.4");
//            con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//            con.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36\n" +
//                    "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            con.setRequestProperty("Cookie", "JSESSIONID=C34FCDADBC2DE5C4B98F129AD177C414");



//            con.setRequestProperty("Accept","application/json, text/javascript, */*; q=0.01");



            int val1 = (int)(Math.random()*100);
            int val2 = (int)(Math.random()*100);
            int val3 = (int)(Math.random()*100);
            int val4 = (int)(Math.random()*1000);
            con.setRequestProperty("x-forwarded-for", "58.57.25.211");
//            con.setRequestProperty("x-forwarded-for", val1+"."+val2+"."+val3+"."+val4);
            if (sbParams != null && sbParams.length() > 0) {
                osw = new OutputStreamWriter(con.getOutputStream(), charset);
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                osw.flush();
            }
            // 读取返回内容
            resultBuffer = new StringBuffer();
//          String HeaderField=  con.getHeaderField("Content-Length");
//          if(!"".equals(HeaderField)&&HeaderField!=null){
//
//        	  int contentLength = Integer.parseInt(HeaderField);
//              if (contentLength > 0) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
//                  }
//              }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }

        return resultBuffer.toString();
    }

    /**
     * @Description:使用URLConnection发送post
     * @author:liuyc
     * @time:2016年5月17日 下午3:26:52
     */
    public static String sendPost2(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> e : params.entrySet()) {
                sbParams.append(e.getKey());
                sbParams.append("=");
                sbParams.append(e.getValue());
                sbParams.append("&");
            }
        }
        URLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        try {
            URL realUrl = new URL(urlParam);
            // 打开和URL之间的连接
            con = realUrl.openConnection();
            // 设置通用的请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            con.setDoOutput(true);
            con.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            osw = new OutputStreamWriter(con.getOutputStream(), charset);
            if (sbParams != null && sbParams.length() > 0) {
                // 发送请求参数
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                // flush输出流的缓冲
                osw.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            resultBuffer = new StringBuffer();
            int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
            if (contentLength > 0) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:发送get请求保存下载文件
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:29
     */
    public static void sendGetAndSaveFile(String urlParam, Map<String, Object> params, String fileSavePath) {
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream os = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            InputStream is = con.getInputStream();
            os = new FileOutputStream(fileSavePath);
            byte buf[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
            }
            os.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    os = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
    }

    /**
     * @Description:使用HttpURLConnection发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:29
     */
    public static String sendGet(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用URLConnection发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:27:58
     */
    public static String sendGet2(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        BufferedReader br = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            URLConnection con = url.openConnection();
            // 设置请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立连接
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用HttpClient发送post请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:28:23
     */
//    public static String httpClientPost(String urlParam, Map<String, Object> params, String charset) {
//        StringBuffer resultBuffer = null;
//        HttpClient client = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(urlParam);
//        // 构建请求参数
//        List<? extends NameValuePair> list = new ArrayList<NameValuePair>();
//        Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Entry<String, Object> elem = iterator.next();
//            list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
//        }
//        BufferedReader br = null;
//        try {
//            if (list.size() > 0) {
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
//                httpPost.setEntity(entity);
//            }
//            HttpResponse response = client.execute(httpPost);
//            // 读取服务器响应数据
//            resultBuffer = new StringBuffer();
//            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                resultBuffer.append(temp);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    br = null;
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return resultBuffer.toString();
//    }

    /**
     * @Description:使用HttpClient发送get请求
     * @author:liuyc
     * @time:2016年5月17日 下午3:28:56
     */
    public static String httpClientGet(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        HttpClient client = new DefaultHttpClient();
        BufferedReader br = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                try {
                    sbParams.append(URLEncoder.encode(String.valueOf(entry.getValue()), charset));
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                sbParams.append("&");
            }
        }
        if (sbParams != null && sbParams.length() > 0) {
            urlParam = urlParam + "?" + sbParams.substring(0, sbParams.length() - 1);
        }
        HttpGet httpGet = new HttpGet(urlParam);
        try {
            HttpResponse response = client.execute(httpGet);
            // 读取服务器响应数据
            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String temp;
            resultBuffer = new StringBuffer();
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                }
            }
        }
        return resultBuffer.toString();
    }

    /**
     * @Description:使用socket发送post请求
     * @author:liuyc
     * @time:2016年5月18日 上午9:26:22
     */
    public static String sendSocketPost(String urlParam, Map<String, Object> params, String charset) {
        String result = "";
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        Socket socket = null;
        OutputStreamWriter osw = null;
        InputStream is = null;
        try {
            URL url = new URL(urlParam);
            String host = url.getHost();
            int port = url.getPort();
            if (-1 == port) {
                port = 80;
            }
            String path = url.getPath();
            socket = new Socket(host, port);
            StringBuffer sb = new StringBuffer();
            sb.append("POST " + path + " HTTP/1.1\r\n");
            sb.append("Host: " + host + "\r\n");
            sb.append("Connection: Keep-Alive\r\n");
            sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
            sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
            // 这里一个回车换行，表示消息头写完，不然服务器会继续等待
            sb.append("\r\n");
            if (sbParams != null && sbParams.length() > 0) {
                sb.append(sbParams.substring(0, sbParams.length() - 1));
            }
            osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write(sb.toString());
            osw.flush();
            is = socket.getInputStream();
            String line = null;
            // 服务器响应体数据长度
            int contentLength = 0;
            // 读取http响应头部信息
            do {
                line = readLine(is, 0, charset);
                if (line.startsWith("Content-Length")) {
                    // 拿到响应体内容长度
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                // 如果遇到了一个单独的回车换行，则表示请求头结束
            } while (!line.equals("\r\n"));
            // 读取出响应体数据（就是你要的数据）
            result = readLine(is, contentLength, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @Description:使用socket发送get请求
     * @author:liuyc
     * @time:2016年5月18日 上午9:27:18
     */
    public static String sendSocketGet(String urlParam, Map<String, Object> params, String charset) {
        String result = "";
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        Socket socket = null;
        OutputStreamWriter osw = null;
        InputStream is = null;
        try {
            URL url = new URL(urlParam);
            String host = url.getHost();
            int port = url.getPort();
            if (-1 == port) {
                port = 80;
            }
            String path = url.getPath();
            socket = new Socket(host, port);
            StringBuffer sb = new StringBuffer();
            sb.append("GET " + path + " HTTP/1.1\r\n");
            sb.append("Host: " + host + "\r\n");
            sb.append("Connection: Keep-Alive\r\n");
            sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
            sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
            // 这里一个回车换行，表示消息头写完，不然服务器会继续等待
            sb.append("\r\n");
            if (sbParams != null && sbParams.length() > 0) {
                sb.append(sbParams.substring(0, sbParams.length() - 1));
            }
            osw = new OutputStreamWriter(socket.getOutputStream());
            osw.write(sb.toString());
            osw.flush();
            is = socket.getInputStream();
            String line = null;
            // 服务器响应体数据长度
            int contentLength = 0;
            // 读取http响应头部信息
            do {
                line = readLine(is, 0, charset);
                if (line.startsWith("Content-Length")) {
                    // 拿到响应体内容长度
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
                // 如果遇到了一个单独的回车换行，则表示请求头结束
            } while (!line.equals("\r\n"));
            // 读取出响应体数据（就是你要的数据）
            result = readLine(is, contentLength, charset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    osw = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    is = null;
                    throw new RuntimeException(e);
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            socket = null;
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @Description:读取一行数据，contentLe内容长度为0时，读取响应头信息，不为0时读正文
     * @time:2016年5月17日 下午6:11:07
     */
    private static String readLine(InputStream is, int contentLength, String charset) throws IOException {
        List<Byte> lineByte = new ArrayList<Byte>();
        byte tempByte;
        int cumsum = 0;
        if (contentLength != 0) {
            do {
                tempByte = (byte) is.read();
                lineByte.add(Byte.valueOf(tempByte));
                cumsum++;
            } while (cumsum < contentLength);// cumsum等于contentLength表示已读完
        } else {
            do {
                tempByte = (byte) is.read();
                lineByte.add(Byte.valueOf(tempByte));
            } while (tempByte != 10);// 换行符的ascii码值为10
        }

        byte[] resutlBytes = new byte[lineByte.size()];
        for (int i = 0; i < lineByte.size(); i++) {
            resutlBytes[i] = (lineByte.get(i)).byteValue();
        }
        return new String(resutlBytes, charset);
    }
}
