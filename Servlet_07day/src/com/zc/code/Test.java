package com.zc.code;

public class Test {
	public static void main (String[] args) {
		int x, ge , shi ,bai ; //定义整型变量
		//三位数 100-999 的水仙花
		for(x=100 ; x < 999 ; x++) {
			ge = x%10 ; //个位计算
			shi = x/10%10 ; //十位计算
			bai = x/10/10%10 ; //百位计算
		
		//判断是否为水仙花数
		if (x== ge*ge*ge + shi*shi*shi + bai*bai*bai) {
			System.out.println("水仙花数：" + x);
		}
		}
		
	}
}
