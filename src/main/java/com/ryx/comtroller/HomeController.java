package com.ryx.comtroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ryx.dao.Classes;
import com.ryx.dao.JieQianYongBean;
import com.ryx.generratorpojo.Teacher;
import com.ryx.pojo.User;
import com.ryx.service.IUserService;
import com.ryx.service.TeacherService;
import com.ryx.util.HttpClientHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 */
// 注解标注此类为springmvc的controller，url映射为"/home"
@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private IUserService userService;

    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;

    @RequestMapping("easyuidemo")
    public String easyuidemo(){
        return "easyui/easyuidemo";
    }
    @RequestMapping("cssdemo")
    public String cssdemo(){
        return "cssdemo";
    }
    @RequestMapping("bootstrap")
    public String bootstrap(){
        return "bootstrap/bootstrap";
    }

    @ResponseBody
    @RequestMapping("inserUsers")
    public String inserUsers(){


        for(int m=2;m<60;m++){
            try {
                String url="http://www.jieqianyong.com.cn:8081/loanSix/user/selectUsers.do?currentPage="+m+"&showCount=10000";
                String result=HttpClientHelper.sendPost(url, null, "UTF-8");
                Document document= Jsoup.parse(result);
                Elements tbodyElement=document.getElementsByTag("tbody");
                Element trElement=  tbodyElement.get(1);
                Elements trElements=trElement.getElementsByTag("tr");
                for (int i=0;i<trElements.size();i++){
                    Element element= trElements.get(i);
                    Elements tdlies=element.getElementsByTag("td");
                    Element element0=tdlies.get(0);
                    Element element1=tdlies.get(1);

                    Element element2=tdlies.get(2);
                    Element element3=tdlies.get(3);
                    Element element4=tdlies.get(4);
                    Element element5=tdlies.get(5);
                    Element element6=tdlies.get(6);
                    System.out.println(element0.text()+","+element1.text()+","+element2.text()+","+element3.text()+","+element4.text()+","+element5.text()+","+element6.text()+",");

                    try {
                        JieQianYongBean jieQianYongBean=new JieQianYongBean(element0.text(),element1.text(),element3.text(),element2.text(),element4.text(),element5.text(),element6.text());
                        int index=userService.insertJieQianYongBean(jieQianYongBean);
                    }catch (Exception e){

                    }

                }
            }catch (Exception e){

            }

        }


        return "success";
    }

    @ResponseBody
    @RequestMapping("findUsersByPage")
    public Object findUsersByPage(@RequestParam int page,@RequestParam int rows ){
        System.out.println("page=="+page+",rows=="+rows);
        int pagestart=(page-1)*rows;
        int pagesend=page*rows;
         List<User> users=   userService.findUsersByPage(pagestart,pagesend);

         JSONObject jsonresultObject=new JSONObject();
         jsonresultObject.put("total",100);
         jsonresultObject.put("rows",users);
        return jsonresultObject;
    }
    @ResponseBody
    @RequestMapping("insertTeacher")
    public String insertTeacher(@ModelAttribute Teacher teacher){
      int id=  teacherService.insert(teacher);
        if(id>0){
         Teacher teacher1=   teacherService.selectByPrimaryKey(id);
            String teacherStr= JSON.toJSONString(teacher1);
            return teacherStr;
        }else{
            return "fail";
        }
    }
    @RequestMapping("getUsers")
    @ResponseBody
    public Object findUsers() {
        List<User> list = userService.getUsers();
        System.out.println("list=="+list.toString());
//        JSONObject jsonObject=new JSONObject();
//       JSONArray jsonArray= JSON.parseArray(JSON.toJSONString(list));
//        jsonObject.put("rows",jsonArray);
        return list;
    }

    @ResponseBody
    @RequestMapping("saveUser")
    public String saveUser(@ModelAttribute User user){
        int a=userService.saveUser(user);
       JSONObject jsonObject= new JSONObject();
        jsonObject.put("success","true");
        return JSON.toJSONString(jsonObject);
    }
    @ResponseBody
    @RequestMapping("editUser")
    public String editUser(@ModelAttribute User user){
       int result= userService.editUser(user);
        JSONObject jsonObject= new JSONObject();
        jsonObject.put("success","true");
        return JSON.toJSONString(jsonObject);
    }

    @RequestMapping("getUserByIdREsponBody/{id}")
    @ResponseBody
    public Object getUserByIdREsponBody(Model model, @PathVariable String id, @RequestParam String pswd){
        User user=  userService.getUserById(id,pswd);
        String result=JSON.toJSONString(user);
        return result ;
    }

    @RequestMapping("getUserById/{id}")
    public String getUserById(Model model, @PathVariable String id, @RequestParam String pswd){
      User user=  userService.getUserById(id,pswd);
        String result=JSON.toJSONString(user);
        model.addAttribute("uid",user.toString());
        model.addAttribute("result",result);
        return "index" ;
    }

//    @Transactional
//    @RequestMapping("saveUser")
//    public String saveUser(@RequestParam int id, @RequestParam String pswd, @RequestParam String username, Model model){
//        User user=new User();
//        user.setId(id);
//        user.setPassword(pswd);
//        user.setUserName(username);
//      int aid=  userService.saveUser(user);
////        String a=null;
////        a.isEmpty();
//        model.addAttribute("aid",aid);
//        return "index";
//    }
    @RequestMapping("insert")
    public String insertData(){
       int i= userService.insertData();
        System.out.println("i=="+i);
        return "index";
    }

    @RequestMapping("xxxTest")
    public ModelAndView getTestHtml() {
        System.out.println("=======================================");
        return new ModelAndView("test.html");
    }












//    @RequestMapping("/ajaxRequest")
//    public void ajaxRequest(@RequestBody Person person, HttpServletResponse response) throws IOException {
//        response.getWriter().print(JSON.toJSONString(person));
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/testAjaxBody")
//    public String ajaxTest(@RequestBody Person person)  {
////            person.setId("423423");
////        Person person=new Person(12,name,"7787");
//        System.out.println("person=="+person);
//            String result=JSON.toJSONString(person);
//            return result;
////        try {
//////            response.getWriter().print(result);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @RequestMapping("/register2")
//    public String register2(@ModelAttribute com.ryx.dao.User user,Model model){
//        model.addAttribute("user",user);
//        return "index";
//    }
//
//
//    @RequestMapping("/registerForm")
//    public String registerForm(Model model){
//        Person user=new Person(43,"name张三","909");
//        List<String> courses=new ArrayList<>();
//        List<String> sexs=new ArrayList<>();
//        sexs.add("男");
//        sexs.add("女");
//        sexs.add("未知");
//        courses.add("Java");
//        courses.add("Spring");
//        courses.add("Spring");
//        user.setReader(true);
////        user.setCourses(courses);
//        user.setSex("女");
//        model.addAttribute("commandw",user);
//        model.addAttribute("user",user);
//        model.addAttribute("courseList",courses);
//        model.addAttribute("sexs",sexs);
//        return "index";
//    }
    @RequestMapping("getClassAndrTeachers")
    @ResponseBody
    public String getClassAndrTeachers(){
       Classes classes= userService.getMapUserAndUsers();
       String result=JSON.toJSONString(classes);
        return result;
    }
    @RequestMapping("getClassAndrTeachersMaps")
    @ResponseBody
    public String getClassAndrTeachersMaps(){
       List<Classes> classes= userService.getClassAndrTeachersMaps();
       String result=JSON.toJSONString(classes);
        return result;
    }
    @RequestMapping("getMaps")
    @ResponseBody
    public String getMaps(){
       List<Map> classes= userService.getMaps();
       String result=JSON.toJSONString(classes);
        return result;
    }

    @RequestMapping("/register")
    public String register(){
//        so
//        sou
//        it
        return "index";
    }
//
//
//    @RequestMapping(value = "/testIndex/{path}",method = {RequestMethod.POST,RequestMethod.GET})
//    public String testIndex(String name,@RequestParam("password") String paswd,Model model,@PathVariable("path") String path){
//
//        model.addAttribute("name",name);
//        model.addAttribute("password",paswd);
//        model.addAttribute("path",path);
////        model.addAttribute("msg","信息");
//////        Map<String,String> aaa=new HashMap<>();
//////        aaa.put("zidibgyi","aaaaTest");
////        Person person=new Person();
////        person.setName(loginname);
////        person.setAge(787);
////        model.addAttribute("kkk",person);
////        model.addAttribute("loginname",loginname);
////        model.addAttribute("username",username);
//        return "index";
//    }
//
//    //映射一个action
//    @RequestMapping("/index")
//    public  String index(ModelMap modelMap, HttpServletRequest request, Model model){
//        //输出日志文件
////        logger.info("the first jsp pages");
////        //返回一个index.jsp这个视图
////        InvokeBat4 test1 = new InvokeBat4();
////        test1.runbat("news");
////        System.out.println("main thread");
//List<PkgBean> pkgBeanList=new ArrayList<>();
//
//      String  contextpath = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
//        File ruihebaoPkg=new File("D:\\soft\\gssoft\\java\\webtomcat\\webapps\\pkg\\Android\\ruishua\\build\\outputs\\apk\\b_ruihebao\\release");
//        if(ruihebaoPkg==null||ruihebaoPkg.listFiles()==null||ruihebaoPkg.listFiles().length==0){
//
//        }else{
//            File[] ruihebaofiles=ruihebaoPkg.listFiles();
//            for (File file1:ruihebaofiles){
//                String filename= file1.getName();
//                if(filename.endsWith("apk")){
//                    PkgBean pkgBean=new PkgBean();
//                    pkgBean.setPkgName(filename);
//                    pkgBean.setPkgUrl(contextpath+"/pkg/Android/ruishua/build/outputs/apk/b_ruihebao/release/"+filename);
//                    pkgBean.setPkgTime(Integer.parseInt(filename.substring(filename.indexOf("."),filename.length())));
//                    pkgBeanList.add(pkgBean);
//                }
//            }
//        }
//        modelMap.put("ruihebaoList",pkgBeanList);
//
//
//
//        return "index";
//    }
//    @RequestMapping("/ruishuapk")
//    public String reshuaapk(ModelMap modelMap,HttpServletRequest request){
//
////        InvokeBat4 test1 = new InvokeBat4();
////        test1.runbat("news");
//
////        return index(modelMap,request);
//        return "";
//    }
//
//
//
//    @RequestMapping("/pkg")
//    public String releasePkg(ModelMap modelMap){
//        File file=new File("D:\\soft\\gssoft\\java\\webtomcat\\webapps\\pkg");
//        File[] files=file.listFiles();
//
////        JSONObject jsonObject=new JSONObject();
//        List<String> namelist=new ArrayList<>();
//        if(files==null||files.length==0){
////            try {
////                jsonObject.put("code","1000");
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
//        }else{
//            for (File file1:files){
//               String filename= file1.getName();
////                nameArray.
//                namelist.add(filename);
//            }
//        }
//        modelMap.addAttribute("namelist",namelist);
//
////        modelMap.put("jsonobj",jsonObject);
//        return "index";
//    }
//    /**
//     * 对字符串进行由小到大排序
//     * @param str    String[] 需要排序的字符串数组
//     */
//    public static void strSort(String[] str){
//        for (int i = 0; i < str.length; i++) {
//            for (int j = i+1; j < str.length; j++) {
//                if(str[i].compareTo(str[j])>0){    //对象排序用camparTo方法
//                    swap(str,i,j);
//                }
//            }
//        }
//
//    }
//    /**
//     * 交换两个元素的位置的方法
//     * @param strSort    需要交换元素的数组
//     * @param i    索引i
//     * @param j 索引j
//     */
//    private static void swap(String[] strSort, int i, int j) {
//        String t = strSort[i];
//        strSort[i] = strSort[j];
//        strSort[j] = t;
//    }
//
//
//    private boolean fileIsExists(String fileUrl){
//        File file=new File(fileUrl);
//        return file.exists();
//    }
//
//
//
//
//
//
//
//
//
//
//    @RequestMapping(method = RequestMethod.GET,value = "/printHello")
//    public String printHello(ModelMap model) {
//        model.addAttribute("message", "Hello Spring MVC Framework!");
//
//        return "index";
//    }
//    @RequestMapping(value = "/user/{userId}/{rodid}",method = RequestMethod.GET,params = "nihao")
//    public String getLogin(@PathVariable("userId") String userId, @PathVariable("rodid") String rodid,ModelMap modelMap){
//        System.out.println("userId==="+userId);
//        System.out.println("rodid==="+rodid);
//        modelMap.put("userId",userId);
//        modelMap.put("roid",rodid);
//
//
//        return "index";
//    }
//    @RequestMapping("/responvalue")
//    @ResponseBody
//    public List<Bean> respone(){
//        List<Bean> list=new ArrayList<Bean>();
//        for (int i=0;i<10;i++) {
//            Bean bean=new Bean();
//            bean.setId(i+"22992");
//            list.add(bean);
//        }
//        return list;
//    }
//
//
//
//    @InitBinder
//    public void initBinder(ServletRequestDataBinder binder){
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
//    }
//
//    @RequestMapping("/date")
//    public String date(Date date){
//        System.out.println(date);
//        return "index";
//    }
//
////    @RequestMapping("/show")
////    @ResponseBody
////    public String showPerson(Map<String,Object> map){
////        Person person=new Person();
////        person.setAge(12);
////        person.setName("zhangsan");
////        map.put("p",person);
////        return map.toString();
////    }
//    @RequestMapping("/getPerson")
//    public void getPerson(String name, PrintWriter printWriter){
//        System.out.println("name=="+name);
//        printWriter.write("hello,"+name);
//    }
//    @RequestMapping("/name")
//    public String sayHello(){
//        return "name";
//    }
//
////    @ModelAttribute ( "hello" )
////    public String getModel() {
////        System. out .println( "-------------Hello---------" );
////        return "world" ;
////    }
////
////    @ModelAttribute ( "intValue" )
////    public int getInteger() {
////        System. out .println( "-------------intValue---------------" );
////        return 10;
////    }
//
////    @RequestMapping ( "sayHello" )
////    public void sayHello(@ModelAttribute ( "hello" ) String hello, @ModelAttribute ( "intValue" ) int num, @ModelAttribute ( "user2" ) User user, Writer writer, HttpSession session) throws IOException {
////        writer.write( "Hello " + hello + " , Hello " + user.getUsername() + num);
////        writer.write( "\r" );
////        Enumeration enume = session.getAttributeNames();
////        while (enume.hasMoreElements())
////            writer.write(enume.nextElement() + "\r" );
////    }
//
////    @ModelAttribute ( "user2" )
////    public User getUser(){
////        System. out .println( "---------getUser-------------" );
////        return new User(3, "user2" );
////    }
//
//    @RequestMapping(value = "/getParams",method = RequestMethod.POST)
//    public String getParams(HttpServletRequest request,ModelMap modelMap,@RequestParam String aaa ){
//       String jjj= request.getParameter("aaa");
//       modelMap.put("bb",jjj);
//       modelMap.put("ccc",aaa);
//        return "index";
//    }
}
