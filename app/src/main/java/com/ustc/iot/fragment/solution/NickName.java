package com.ustc.iot.fragment.solution;

/*
 * 包名：      com.ustc.iot.fragment.solution
 * 文件名：      A
 * 创建时间：      2020/6/30 2:21 AM
 *
 */

import java.util.Random;

public class NickName {

    private static String adjective[] = {
            "一样的", "喜欢的", "美丽的", "一定的", "原来的", "美好的", "开心的", "可能的", "可爱的",
            "明白的", "所有的", "后来的", "重要的", "经常的", "自然的", "真正的", "害怕的", "空中的",
            "红色的", "痛苦的", "干净的", "辛苦的", "精彩的", "欢乐的", "进步的", "影响的", "黄色的",
            "亲爱的", "根本的", "完美的", "金黄的", "聪明的", "清新的", "迷人的", "光明的", "共同的",
            "直接的", "真实的", "听说的", "用心的", "飞快的", "雪白的", "着急的", "乐观的", "主要的",
            "鲜艳的", "冰冷的", "细心的", "奇妙的", "水平的", "动人的", "大量的", "无知的", "礼貌的",
            "暖和的", "深情的", "正常的", "平淡的", "光亮的", "落后的", "大方的", "老大的", "刻苦的",
            "晴朗的", "专业的", "永久的", "大气的", "知己的", "刚好的", "相对的", "平和的", "友好的",
            "广大的", "秀丽的", "日常的", "高级的", "相同的", "笔直的", "安定的", "知足的", "结实的",
            "许久的", "听话的", "知名的", "闷热的", "众多的", "拥挤的", "天生的", "迷你的", "老实的",
            "友爱的", "原始的", "可笑的", "合格的", "公共的", "大红的", "得力的", "洁净的", "暗淡的",
            "鲜红的", "桃红的", "吓人的", "多余的", "秀美的", "繁忙的", "冰凉的", "热心的", "空旷的",
            "冷清的", "公开的", "冷淡的", "齐全的", "草绿的", "能干的", "发火的", "可心的", "业余的",
            "空心的", "凉快的", "长远的", "土黄的", "和好的", "合法的", "明净的", "过时的", "低下的",
            "不快的", "低级的", "中用的", "不定的", "公办的", "用功的", "少许的", "忙乱的", "日用的",
            "要紧的", "少见的", "非分的", "怕人的", "大忙的", "幸福的", "特别的", "未来的", "伟大的",
            "困难的", "伤心的", "实在的", "现实的", "丰富的", "同样的", "巨大的", "耐心的", "优秀的",
            "亲切的", "讨厌的", "严厉的", "积极的", "整齐的", "环保的"};

    public static String[] noun = {
            "繁易物联", "小米", "德勤", "飞利浦", "格力", "盈科互动", "大连飞翔科技", "GE",
            "深圳天圆数码", "研华", "繁易科技", "JG",  "盈科互动", "杭州华三", "深圳迅记", "AMS",
            "北京微控", "成都万创", "~$语祯物联", "广州晓网科技", "Anybus", "上海思博", "邦纳", "国内", "Lord",
           };
    public static String[] address = {
            "台湾 桃源县", "重庆 重庆市", "北京 东城区", "广东省 梅州市",

    };public static String[] desc = {
            "邻近感测泊车辅助占位检测简单手势识别车门开启器应用",
    };
    public static String[] people = {
            "赵超", "杜敏", "丁娟", "孙平"

    };
    public static String[] type = {
            "智慧城市", "智慧安防", "智慧农业", "智能家居"

    };
    /**
     * 生成随机昵称
     *
     * @return
     */
    public static String generateName() {
        int adjLen= adjective.length;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        sb.append(adjective[random.nextInt(adjLen)]);
        return sb.toString();
    }
    public static String generateName2() {
        int nLen= noun.length;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        sb.append(noun[random.nextInt(nLen)]);
        return sb.toString();
    }
    public static String generateName3(String[] arr) {
        int nLen= arr.length;
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        sb.append(arr[random.nextInt(nLen)]);
        return sb.toString();
    }
}


