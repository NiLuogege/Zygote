package com.tmholter.pediatrics.xhjdemo.constants;


/**
 * 保存常量的类
 * 
 * @author kevin
 */
public class CommonConfig {

	// 是否使用测试服务器
	public static final boolean TEST_SERVER = true;

	// 是否测试CSS版本
	public static final boolean TEST_CSS = false;

//	// 调试开关
//	public static final boolean DEBUG = BuildConfig.LOG_DEBUG;
//
//	/**
//	 * 是否是使用新的dsp广告接口版本
//	 */
//	public static final boolean USE_NEW_DSP_AD = BuildConfig.NEW_DSP_AD;

	// 是否成功开启bugtags
	public static boolean USE_BUGTAGS = false;

	private static String logIme[] = {"865624028814748", "867857029618357", "867247026818749","863100033221122","863100033221130","864177032911431","862259030436660","864739038533715",
			"867516024517440","352204061216687","861744037476711","861744037476703", "867323025430487","866375025175141","862021035278335","861913031389440","864739038533707",
			"866333025048842","869296020130831","865586021623139","869161020709309","863908026553941","865166023700613","99000645377769","860162036749874","869161020709309","863554031752019"};


	public static boolean isTestIme(String ime) {
		for (int i = 0; i < logIme.length; i++) {
			if (logIme[i].equals(ime)) {
				return true;
			}
		}
		return false;
	}
}
