{
	"dailyUser" : {
	<#if modelDailyUser?has_content>
		"dailyQuestId" : "${modelDailyUser.dailyQuestId?if_exists}",
		"dailyUserTime" : "${modelDailyUser.dailyUserTime?if_exists}",
		"dailyGrantFlag" : "${modelDailyUser.dailyGrantFlag?if_exists}"
	</#if>
	}
}
