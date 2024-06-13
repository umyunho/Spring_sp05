package com.himedia.sp05;

import com.himedia.sp05.dao.WordDao;
import com.himedia.sp05.dto.WordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        String[] keyWords = {"c", "c++", "java", "jsp",  "spring"};

        String[] values = {
                "C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발한 프로그래밍 언어이다.",
                "C++는 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 프로그래밍 언어이다.",
                "자바는 썬 마이크로시스템즈의 제임스 James Gosling과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다.",
                "JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다.",
                "스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도 불린다."
        };

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
        WordDao wdao = ctx.getBean("worddao", WordDao.class);

/*
        for( int i=0; i<keyWords.length; i++ ) {
            WordDto wdto = new WordDto();
            wdto.setWordKey(keyWords[i]);
            wdto.setWordValue(values[i]);
            wdao.insertWord(wdto);
        }
*/

        //레코드 모두를 불러와서 화면에 출력 양식은 자유
        ArrayList<WordDto> list = wdao.seleceWord();
        for (WordDto wtd1 : list) {
            System.out.println("| key : " + wtd1.getWordKey());
            System.out.println("| value : " + wtd1.getWordValue());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 단어를 입력하세요 : ");
        String input = sc.nextLine();

        WordDto wdto = wdao.searchWord(input);

        if(wdto == null){
            System.out.println("검색한 단어는 존재하지 않습니다");
        }else{
            System.out.println("key : " + wdto.getWordKey() + "\n");
            System.out.println("value : " + wdto.getWordValue() + "\n");
        }

    }
}
