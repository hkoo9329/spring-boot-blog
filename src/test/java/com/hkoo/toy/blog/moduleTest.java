package com.hkoo.toy.blog;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class moduleTest {

    @Test
    public void spaceBarToChange() {
        //마크 다운 내부 링크 이동 이름 바꾸기 귀찮아서 하나 만듦
        String s = "JQuery를 이용한 ID, Class, Name 별로 Input Value 값 가져오기";
        s = s.replace(' ', '-');
        System.out.println(s);
    }




}
