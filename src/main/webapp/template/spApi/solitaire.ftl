{

	"sample" : {			
		"result" : "ok", "nowTime" : "${nowTime?if_exists}"		
	},

	"dailyQuest" : {
	<#if modelDailyQuest?has_content>
		"dailyQuestId" : "${modelDailyQuest.dailyQuestId?if_exists}",
		"dailyQuestStart" : "${modelDailyQuest.dailyQuestStart?if_exists?date?string("yyyy/MM/dd HH:mm:ss")}",
		"dailyQuestEnd" : "${modelDailyQuest.dailyQuestEnd?if_exists?date?string("yyyy/MM/dd HH:mm:ss")}",
		"dailyQuestTitle" : "${modelDailyQuest.dailyQuestTitle?if_exists}",
		"dailyQuestTalon" : "${modelDailyQuest.dailyQuestTalon?if_exists}",
		"dailyQuestBoard" : "${modelDailyQuest.dailyQuestBoard?if_exists}",
		"dailyGrantItem" : "${modelDailyQuest.dailyGrantItem?if_exists}",
		"dailyGrantValue" : "${modelDailyQuest.dailyGrantValue?if_exists}",
		"dailyGrantFlag" : "${modelDailyQuest.dailyGrantFlag?if_exists}"
	</#if>
	}

}
