package ItemRecom2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <ul>
 * <li>推荐入口</li>
 * <li>@author root
 * 
 */
public class Recommend {
	public static final String FS = "file:///d:/bigdata/hadoop/test";
	public static final Pattern DELIMITER = Pattern.compile("[\t,]");

	public static void main(String[] args)
			throws ClassNotFoundException, IOException, URISyntaxException, InterruptedException {
		Map<String, String> path = new HashMap<String, String>();
		path.put("Step1Input", FS + "/data.csv");
		path.put("Step1Output", FS + "/output/step1");
		path.put("Step2Input", path.get("Step1Output"));
		path.put("Step2Output", FS + "/output/step2");
		path.put("Step3Input1", path.get("Step1Output"));
		path.put("Step3Output1", FS + "/output/step3_1");
		path.put("Step3Input2", path.get("Step2Output"));
		path.put("Step3Output2", FS + "/output/step3_2");
		path.put("Step4Input1", path.get("Step3Output1"));
		path.put("Step4Input2", path.get("Step3Output2"));
		path.put("Step4Output", FS + "/output/step4");
		Step1.runStep1(path);
		Step2.runStep2(path);
		Step3.runStep3_1(path);
		Step3.runStep3_2(path);
		Step4.runStep4(path);
		System.exit(0);
	}
}