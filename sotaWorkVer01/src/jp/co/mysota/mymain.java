//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.camera.*;
import	java.awt.Color;

public class mymain
{

	public CPlayWave cplay;
	public String speechRecogResult;
	public RecogResult recogresult;
	public long noDetectDuration;
	public CRobotPose pose;
	public String date_string;
	public String time_string;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,544,32,False,8,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CPlayWave cplay*/;																							//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,7,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,6,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		noDetectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String date_string*/;																							//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String time_string*/;																							//@<BlockInfo>jp.vstone.block.variable,480,32,480,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void faceTracking()																							//@<BlockInfo>jp.vstone.block.func,64,224,1488,272,False,21,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,128,224,1424,272,False,20,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.thread,256,224,480,272,False,19,スレッド@</BlockInfo>
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							
							
																														//@<OutputChild>
							while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,240,368,368,368,False,10,Endless@</BlockInfo>
							{
							
																																	//@<OutputChild>
								noDetectDuration = GlobalVariable.robocam.getNotDetectDuration();									//@<BlockInfo>jp.vstone.block.facedetect.nodetectduration.get,304,368,304,368,False,9,顔が見えていない場合、その累積時間を変数long noDetectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
																																	//@</OutputChild>
							}
																																	//@<EndOfBlock/>
																																		//@</OutputChild>

							
						} catch(Exception e) {
							CRobotUtil.Err("jp.vstone.block.thread","例外が発生しました。");
							e.printStackTrace();
						}
					}
				});
				th.start();
			}
																														//@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,608,272,1296,272,False,18,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,672,224,1232,224,False,17,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)8)
				{
																														//@<OutputChild>
					GlobalVariable.robocam.setEnableFaceSearch(false);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,736,224,736,224,False,16,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
					GlobalVariable.sotawish.stop();																		//@<BlockInfo>jp.vstone.block.talk.say,800,224,800,224,False,15,@</BlockInfo>
					if(cplay != null){
					    cplay.stop();
					}

					{
						String selectLang = "日本語";

						switch(selectLang){
							case "日本語":
								jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
								break;
							case "英語":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
								break;
							case "中国語_簡体字":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
								break;
							case "中国語_繁体字":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
								break;
							case "韓国語":
								jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
								break;
							default:
								break;
						}
					}
					GlobalVariable.sotawish.Say((String)"ようこそ 秋田県庁 第二庁舎 へ",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
					while(noDetectDuration<6)																			//@<BlockInfo>jp.vstone.block.while,880,224,1008,224,False,14,TRUE@</BlockInfo>
					{


																														//@<OutputChild>
						talk1();																						//@<BlockInfo>jp.vstone.block.callfunc.base,944,224,944,224,False,11,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					ActBye();																							//@<BlockInfo>jp.vstone.block.callfunc.base,1072,224,1072,224,False,13,@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.robocam.setEnableFaceSearch(true);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,1136,224,1136,224,False,12,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

				}else
				{
																														//@<OutputChild>
																														//@</OutputChild>

				}
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>


		}finally{
			GlobalVariable.robocam.StopFaceTraking();
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void ActBye()																								//@<BlockInfo>jp.vstone.block.func,720,496,1104,496,False,27,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,784,496,784,496,False,26,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,848,496,848,496,False,25,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,912,496,912,496,False,24,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,260,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,976,496,976,496,False,23,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,700);
		CRobotUtil.wait(700);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,1040,496,1040,496,False,22,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,544,32,784,32,False,30,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,608,32,608,32,False,29,@</BlockInfo>
		if(cplay != null){
		    cplay.stop();
		}

		{
			String selectLang = "日本語";

			switch(selectLang){
				case "日本語":
					jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
					break;
				case "英語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
					break;
				case "中国語_簡体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
					break;
				case "中国語_繁体字":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
					break;
				case "韓国語":
					jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
					break;
				default:
					break;
			}
		}
		GlobalVariable.sotawish.Say((String)"プログラムを実行開始します",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																														//@<EndOfBlock/>
		faceTracking();																									//@<BlockInfo>jp.vstone.block.callfunc.base,672,32,672,32,False,28,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void talk1()																									//@<BlockInfo>jp.vstone.block.func,336,2272,1344,2256,False,79,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);											//@<BlockInfo>jp.vstone.block.talk.speechrecog.regex2,432,784,1088,784,False,78,音声認識を行い、結果を条件に正規表現文字列で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
		speechRecogResult = recogresult.CheckBest(new String[]{
		 ".*こんにちは.*" ,  ".*ここはどこ.*" ,  ".*お名前は.*" ,  ".*さようなら.*" ,  ".*おはよう.*" ,  ".*元気.*" ,  ".*ありがとう.*" ,  ".*今日は何日.*" ,  ".*いま何時.*" ,  ".*教育庁.*" ,  ".*高校教育.*" ,  ".*特別支援教育.*" ,  ".*義務教育.*" ,  ".*保健体育.*" ,  ".*幼保.*" ,  ".*公営企業.*" ,  ".*うまいもの.*" ,  ".*スポーツ振興.*" ,  ".*文化振興.*" ,  ".*文化財保護.*" ,  ".*生涯学習.*" ,  ".*福利.*" ,  ".*施設整備.*" ,  ".*情報規格.*" ,  ".*情報化研修.*" ,  ".*総合防災.*" ,  ".*災害対策本部.*" ,  ".*産業労働.*" ,  ".*三ローブ.*" ,  ".*デジタル.*" ,  ".*資源エネルギー産業.*" ,  ".*産業集積.*" ,  ".*産業政策.*" ,  ".*地域産業振興.*" ,  ".*ちさんか.*" ,  ".*食品工業.*" ,  ".*輸送機.*" ,  ".*商業貿易.*" ,  ".*雇用労働.*" ,  ".*活性化センター.*" ,  ".*観光文化スポーツ.*" ,  ".*観光連盟.*" ,  ".*観光振興.*" ,  ".*交通政策.*" ,  ".*観光戦略.*" ,  "" , 
		},true);
		if(speechRecogResult == null) speechRecogResult = "";

		if(speechRecogResult.contains((String)".*こんにちは.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,784,544,784,False,31,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"こんにちは",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ここはどこ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,880,544,880,False,32,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ここは秋田県庁 第二庁舎 です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*お名前は.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,976,544,976,False,33,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ソータ です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*さようなら.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1072,544,1072,False,34,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"さようなら、また来てね",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*おはよう.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1168,544,1168,False,35,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"おはようございます",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*元気.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1264,544,1264,False,36,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"僕は元気です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ありがとう.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1360,544,1360,False,37,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"どういたしまして",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*今日は何日.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				date_string = CRobotUtil.getDateString();																	//@<BlockInfo>jp.vstone.block.time.getdate,544,1456,544,1456,False,39,ロボット内のカレンダーより現在年月日を文字列で取得し、変数String date_stringに代入。@</BlockInfo>
																															//@<EndOfBlock/>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,656,1456,656,1456,False,38,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)date_string,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*いま何時.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				time_string = CRobotUtil.getTimeString();																	//@<BlockInfo>jp.vstone.block.time.gettime,544,1552,544,1552,False,41,ロボット内のカレンダーより現在時刻を文字列で取得し、変数String time_stringに代入。@</BlockInfo>
																															//@<EndOfBlock/>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,656,1552,656,1552,False,40,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)time_string,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*教育庁.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1648,544,1648,False,42,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁は７階と6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*高校教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1744,544,1744,False,43,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"高校教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*特別支援教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1840,544,1840,False,44,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"特別支援教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*義務教育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,1936,544,1936,False,45,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"義務教育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*保健体育.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,544,2032,544,2032,False,46,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"保健体育課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*幼保.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2128,560,2128,False,47,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"幼保推進課は７階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*公営企業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2224,560,2224,False,48,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"公営企業課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*うまいもの.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2320,560,2320,False,49,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"秋田うまいもの販売課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*スポーツ振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2416,560,2416,False,50,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"スポーツ振興課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*文化振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2512,560,2512,False,51,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"文化振興課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*文化財保護.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2608,560,2608,False,52,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"文化財 保護室は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*生涯学習.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2704,560,2704,False,53,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"生涯学習課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*福利.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2800,560,2800,False,54,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁福利課は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*施設整備.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2896,560,2896,False,55,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"教育庁施設整備室は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*情報規格.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,2992,560,2992,False,56,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"情報企画課は5階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*情報化研修.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,3088,560,3088,False,57,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"情報化研修室は5階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*総合防災.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,560,3184,560,3184,False,58,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"総合防災課は4階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*災害対策本部.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,576,3280,576,3280,False,59,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"災害対策本部室は4階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業労働.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,640,3376,640,3376,False,60,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業労働部は3階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*三ローブ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,640,3472,640,3472,False,61,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業労働部は3階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*デジタル.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,640,3568,640,3568,False,62,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"デジタルイノベーション戦略室は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*資源エネルギー産業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,640,3664,640,3664,False,63,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"資源エネルギー産業課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業集積.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,608,3760,608,3760,False,64,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業集積課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*産業政策.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,608,3856,608,3856,False,65,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"産業政策課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*地域産業振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,3952,592,3952,False,66,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課は3階ですが，食品工業班は6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*ちさんか.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4048,592,4048,False,67,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課は3階ですが，食品工業班は6階にあります",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*食品工業.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4144,592,4144,False,68,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"地域産業振興課食品工業班は6階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*輸送機.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4240,592,4240,False,69,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"輸送機産業振興室は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*商業貿易.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4336,592,4336,False,70,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"商業貿易課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*雇用労働.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4432,592,4432,False,71,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"雇用労働政策課は3階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*活性化センター.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4528,592,4528,False,72,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"あきた企業活性化センターは2階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光文化スポーツ.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4624,592,4624,False,73,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光文化スポーツ部は1階と6階にあります．課名を仰ってください．",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光連盟.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4720,592,4720,False,74,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"秋田県観光連盟は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光振興.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4816,592,4816,False,75,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光振興課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*交通政策.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,4912,592,4912,False,76,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"交通政策課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else if(speechRecogResult.contains((String)".*観光戦略.*"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,5008,592,5008,False,80,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"観光戦略課は1階です",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
		else
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,592,5104,592,5104,False,77,@</BlockInfo>
				if(cplay != null){
				    cplay.stop();
				}
				
				{
					String selectLang = "日本語";
				
					switch(selectLang){
						case "日本語":
							jp.vstone.sotatalk.TextToSpeechSota.cancelLocalize();
							break;
						case "英語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("en");
							break;
						case "中国語_簡体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-chs");
							break;
						case "中国語_繁体字":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("zh-cht");
							break;
						case "韓国語":
							jp.vstone.sotatalk.TextToSpeechSota.setLocalizeLang("ko");
							break;
						default:
							break;
					}
				}
				GlobalVariable.sotawish.Say((String)"ごめんなさい 聞き取れませんでした",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);
																															//@<EndOfBlock/>
																																//@</OutputChild>

		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
