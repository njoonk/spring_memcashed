{

	"dailyUsersPlayTypeList" : {
		<#if model.mapDailyUserPlayType?has_content>
		<#list model.mapDailyUserPlayType?keys as key>
			"${key}" : "${model.mapDailyUserPlayType[key]?if_exists}"<#if key_has_next>,</#if>
		</#list>
		</#if>
	},

	"userDataList" : {
	<#if modelUserList?has_content>
	<#list modelUserList as sampleUser > 
		"${sampleUser.userAmebaId?if_exists}" : {
			"userTotalScore" : "${sampleUser.userTotalScore?if_exists}",
			"userBestScore" : "${sampleUser.userBestScore?if_exists}",
			"userBestTime" : "${sampleUser.userBestTime?if_exists}",
			"userBestRanking" : "${sampleUser.userBestRanking?if_exists}",
			"userBestRankingTime" : "${sampleUser.userBestRankingTime?if_exists}",
			"userWonCnt" : "${sampleUser.userWonCnt?if_exists}",
			"userWonLineCnt" : "${sampleUser.userWonLineCnt?if_exists}",
			"userBestWonLineCnt" : "${sampleUser.userBestWonLineCnt?if_exists}",
			"userGlasses" : "${sampleUser.userGlasses?if_exists}",
			"userNickname" : "${sampleUser.userNickname?if_exists}",
			"userGender" : "${sampleUser.userGender?if_exists}"
		}<#if sampleUser_has_next>,</#if>

	</#list>
	</#if>
	}

}