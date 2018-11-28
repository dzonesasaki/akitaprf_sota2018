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

	public String speechRecogResult;
	public RecogResult recogresult;
	public long noDetectDuration;
	public CRobotPose pose;
	public CPlayWave cplay;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,416,32,False,5,@</BlockInfo>
	{
																														//@<OutputChild>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		noDetectDuration=0;																								//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CPlayWave cplay*/;																							//@<BlockInfo>jp.vstone.block.variable,352,32,0,0,False,0,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void talk1()																									//@<BlockInfo>jp.vstone.block.func,32,768,464,768,False,11,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)20000);											//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,112,624,336,624,False,10,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
		speechRecogResult = recogresult.CheckBest(new String[]{
		 "こんにちは" ,  "名前は" ,  "ここはどこ" ,  "" , 
		},false);
		if(speechRecogResult == null) speechRecogResult = "";

		if(speechRecogResult.contains((String)"こんにちは"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,192,624,192,624,False,6,@</BlockInfo>
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
		else if(speechRecogResult.contains((String)"名前は"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,192,720,192,720,False,7,@</BlockInfo>
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
		else if(speechRecogResult.contains((String)"ここはどこ"))
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,192,816,192,816,False,8,@</BlockInfo>
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
		else
		{
			speechRecogResult = recogresult.getBasicResult();
			if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
				GlobalVariable.sotawish.stop();																				//@<BlockInfo>jp.vstone.block.talk.say,192,912,192,912,False,9,@</BlockInfo>
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

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,480,32,752,32,False,14,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.stop();																					//@<BlockInfo>jp.vstone.block.talk.say,544,32,544,32,False,13,@</BlockInfo>
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
		faceTracking();																									//@<BlockInfo>jp.vstone.block.callfunc.base,608,32,608,32,False,12,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void ActBye()																								//@<BlockInfo>jp.vstone.block.func,608,656,992,656,False,20,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,672,656,672,656,False,19,コメント@</BlockInfo>
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
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,736,656,736,656,False,18,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,800,656,800,656,False,17,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,260,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,864,656,864,656,False,16,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,690,-20,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,1000);
		CRobotUtil.wait(1000);																							//@<EndOfBlock/>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,928,656,928,656,False,15,コメント@</BlockInfo>
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
	public void faceTracking()																							//@<BlockInfo>jp.vstone.block.func,32,192,1456,240,False,33,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.robocam.setEnableFaceSearch(true);																//@<BlockInfo>jp.vstone.block.facedetect.traking,96,192,1392,240,False,32,顔追従@</BlockInfo>
		GlobalVariable.robocam.setEnableSmileDetect(true);
		GlobalVariable.robocam.setEnableAgeSexDetect(true);

		GlobalVariable.robocam.StartFaceTraking();
		try{
			GlobalVariable.detectCount=0;


																														//@<OutputChild>
			{																											//@<BlockInfo>jp.vstone.block.thread,224,192,448,240,False,31,スレッド@</BlockInfo>
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try{
							
							
																														//@<OutputChild>
							while(GlobalVariable.TRUE)																				//@<BlockInfo>jp.vstone.block.while.endless,208,336,336,336,False,22,Endless@</BlockInfo>
							{
							
																																	//@<OutputChild>
								noDetectDuration = GlobalVariable.robocam.getNotDetectDuration();									//@<BlockInfo>jp.vstone.block.facedetect.nodetectduration.get,272,336,272,336,False,21,顔が見えていない場合、その累積時間を変数long noDetectDurationに返す。@</BlockInfo>	@<EndOfBlock/>
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
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,576,240,1264,240,False,30,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				GlobalVariable.faceresult = GlobalVariable.robocam.getDetectResult();									//@<BlockInfo>jp.vstone.block.facedetect.isdetect,640,192,1200,192,False,29,コメント@</BlockInfo>

				if(GlobalVariable.faceresult.isDetect()) GlobalVariable.detectCount++;
				else GlobalVariable.detectCount=0;

				if(GlobalVariable.detectCount>(int)1)
				{
																														//@<OutputChild>
					GlobalVariable.robocam.setEnableFaceSearch(false);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,704,192,704,192,False,28,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
																														//@<EndOfBlock/>
					GlobalVariable.sotawish.stop();																		//@<BlockInfo>jp.vstone.block.talk.say,768,192,768,192,False,27,@</BlockInfo>
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
					while(noDetectDuration<6)																			//@<BlockInfo>jp.vstone.block.while,848,192,976,192,False,26,TRUE@</BlockInfo>
					{


																														//@<OutputChild>
						talk1();																						//@<BlockInfo>jp.vstone.block.callfunc.base,912,192,912,192,False,23,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
					}
																														//@<EndOfBlock/>
					ActBye();																							//@<BlockInfo>jp.vstone.block.callfunc.base,1040,192,1040,192,False,25,@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.robocam.setEnableFaceSearch(true);													//@<BlockInfo>jp.vstone.block.facedetect.traking.serchenable,1104,192,1104,192,False,24,顔追跡中に顔が見つからない場合、自動的に首を動かして周囲の顔をサーチするかどうかの設定@</BlockInfo>
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

}
