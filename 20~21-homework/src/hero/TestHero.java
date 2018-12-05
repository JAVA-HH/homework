package hero;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero {
    public static void main(String[] args) throws IOException {
        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        // 2. 按出生地分组
        // 3. 找出寿命前三的武将
        // 4. 女性寿命最高的
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超

        Stream<String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        ArrayList<Hero> heroes = new ArrayList<>();
        lines.forEach(s-> {
            String[] split = s.split("\t");
            Hero hero = new Hero(Integer.parseInt(split[0]),
                    split[1], split[2], split[3],
                    Integer.parseInt(split[4]),
                    Integer.parseInt(split[5]),
                    Integer.parseInt(split[6]));
            heroes.add(hero);
        });
        //1.找出武将中武力排名前三的hero对象，提示流也可以排序
        List<Hero> list = heroes.stream().sorted((a, b) ->
                b.getPower() - a.getPower()).limit(3).collect(Collectors.toList());
        System.out.println("1、武将中武力排名前三的武将");

        for (Hero hero : list) {
            int i=0;
            System.out.println("排名第"+(++i)+"的是: "+hero.getName()+"武力值为: "+hero.getPower());
        }
        System.out.println("====================================");
        //2、按出生地分组
        Map<String, List<Hero>> mapLoc = heroes.stream().collect(Collectors.groupingBy(s -> s.getLoc()));
        System.out.println("2、按出生地分组");
        mapLoc.forEach((key,value)-> System.out.println(key+"=="+value));
        System.out.println("===============================");
        //3、找出寿命排名前三的武将
        List<Hero> listLife = heroes.stream().sorted((a, b) -> (b.getDeath() - b.getBirth()) - (a.getDeath() - a.getBirth())).limit(3).collect(Collectors.toList());
        System.out.println("3、寿命排名前三的武将");
        for (Hero hero : listLife) {
            int i=0;
            System.out.println("寿命排名第"+(++i)+"的是: "+hero.getName()+"寿命为: "+(hero.getDeath()-hero.getBirth()));
        }
        System.out.println("======================================");
        //4、女生寿命最高的
//        heroes.stream().filter(hero -> hero.getSex().equals("女")).sorted((a,b)->((b.getDeath()-b.getBirth())-(a.getDeath()-a.getBirth()))).limit(1).forEach(s-> System.out.println(s));
        Optional<Hero> heroSexAge = heroes.stream().filter(hero -> hero.getSex().equals("女")).max((a, b) -> {
            int age1 = a.getDeath() - a.getBirth();
            int age2 = b.getDeath() - b.getBirth();
            return age1 - age2;
        });
        Hero hero = heroSexAge.get();
        System.out.println("4、求女生寿命最高");
        System.out.println("女性中寿命最长的是： "+hero.getName()+"活了："+(hero.getDeath()-hero.getBirth()));
        System.out.println("===========================================");
        //5、找出武力排名前三100,99,97,97
        List<Hero> list1 = heroes.stream().sorted((a, b) -> b.getPower() - a.getPower()).collect(Collectors.toList());

        int n=3;
        while (n<list1.size()){
            if (list1.get(n).getPower()==list1.get(++n).getPower()){
                //如果第三个人的武力值等于第四个人的武力值 就给i+1
            }else {
                break;
            }
        }
        List<Hero> list2 = list1.stream().limit(n).collect(Collectors.toList());
        System.out.println("5、找出排名前三的人包括并列名次");
        for (Hero hero1 : list2) {

            System.out.println("排名前三的是: "+hero1.getName()+"武力值为："+hero1.getPower());
        }
        System.out.println("=======================================");
        //6、按各个年龄段分组：0~20,21~41,41~60,60以上

        Map<String, List<Hero>> mapAge = heroes.stream().collect(Collectors.groupingBy(hero2 -> {
            if (hero2.age() >= 0 && hero2.age() <= 20) {
                return "年龄为0-20";
            } else if (hero2.age() >= 21 && hero2.age() <= 40) {
                return "年龄为21-40";
            } else if (hero2.age() >= 41 && hero2.age() <= 60) {
                return "年龄为41-60";
            } else {
                return "年龄为60以上";
            }

        }));
        System.out.println("6、按年龄段分组0~20,21~41,41~60,60以上");
        mapAge.forEach((key,value)-> System.out.println(key+"=="+value));
        System.out.println("=============================");
        //7、按武力分组：>=90，80~89,70~79,<70
        Map<String, List<Hero>> map1 = heroes.stream().collect(Collectors.groupingBy(hero3 -> {
            if (hero3.getPower() >= 90) {
                return "武力值大于90";
            } else if (hero3.getPower() >= 80 && hero3.getPower() < 90) {
                return "武力值为80-89";
            } else if (hero3.getPower() >= 70 && hero3.getPower() < 79) {
                return "武力值为70-79";
            } else {
                return "武力值小于70";
            }
        }));
        System.out.println("7、按武力分组：>=90，80~89,70~79,<70");
        map1.forEach((key,value)-> System.out.println(key+"=="+value));
        System.out.println("============================================");

        //8、按出生地分组后，统计各组人数
        HashMap<String, Integer> countmap = new HashMap<>();
        int count = 1;
        for (Map.Entry<String, List<Hero>> loc : mapLoc.entrySet()) {
            String key = loc.getKey();
            countmap.put(key, count);
            count++;
        }
        System.out.println("8、按出生地分组后，统计各组人数");
        countmap.forEach((key,value)-> System.out.println("住在："+key+"的有: "+value+"个人"));
    }

}
