package com.ryx.test;

import com.ryx.dao.JieQianYongBean;
import com.ryx.service.IUserService;
import com.ryx.util.HttpClientHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyBatisTest {

    @Autowired
    @Qualifier("UserServiceImpl")
    private static IUserService userService;


    public static void main(String[] args) {

        try {

            String url="http://www.jieqianyong.com.cn:8081/loanSix/user/selectUsers.do?currentPage=1&showCount=10";
            String result=HttpClientHelper.sendPost(url, null, "UTF-8");
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

                JieQianYongBean jieQianYongBean=new JieQianYongBean(String.valueOf(i),element1.text(),element3.text(),element2.text(),element4.text(),element5.text(),element6.text());
                int index=userService.insertJieQianYongBean(jieQianYongBean);
            }







//            var list = new ArrayList<String>();
//            list.add("hello，world！");
//            System.out.println(list);

            //            Arrays.asList("p","w","r","r","rt","te","v","nvb").forEach(s -> System.out.println(s));
//                long a=10000_00_000;
//            System.out.println(a);
//            System.out.println("Line %d: %s%n", 2, 1);

//            Thread thread2=  new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    Thread thread=new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            String a=null;
//                            System.out.println(a.toString());
//                        }
//                    });
//                    thread.start();
//                }
//            });
//            thread2.setUncaughtExceptionHandler(new SimpleThreadExceptionHandler());
//            thread2.start();



//            BuyHouse buyHouse=new BuyHouseImpl();
//            BuyHouse proxyBuyHouse= (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),new Class[]{BuyHouse.class},new DynamicProxyHandler(buyHouse));
//            proxyBuyHouse.buyHosue2();

//            Class<?>  clazz=   Class.forName("com.ryx.test.proxy.A");
//            Object object=clazz.newInstance();
//           Method method= clazz.getMethod("foo",String.class);
//            method.invoke(object,"333333333");

//            InputStream inputStream= Resources.getResourceAsStream("/mapper/mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession session= sqlSessionFactory.openSession();
//            User user=new User(5,"name","性别","年龄");
//            session.insert("com.ryx.dao.UserMapper.save",user);
//            session.commit();
//            session.close();
//            final Random random = new Random();
//            List<User> stuList = new ArrayList<User>() {
//                {
//                    for (int i = 0; i < 100; i++) {
//                        add(new User("student" + i+random.nextInt(50) + 50));
//                    }
//                }
//            };
//
//            stuList.stream().filter(a->a.getLoginname()!=null).sorted((User user, User t1)->1).collect(Collectors.toList());

//            List<Integer> numbers = Arrays.asList(2, 5, 8, 15, 12, 19, 50, 23);
//            numbers.stream().filter(e->e>10).map(e->e*2).findFirst().map(e-> "The value is " + e);


//            System.out.println(2-1.1);
//            System.out.println(1.0-0.9);


//            System.out.println("111111111111");
//            if(true){
//                return;
//            }
//            System.out.println("22222222222222");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("---------finally-------");
        }
    }

}
