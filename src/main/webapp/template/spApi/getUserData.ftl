{

	"getUserData" : {
	<#if modelUser?has_content>
		"userAmebaId" : "${modelUser.userAmebaId?if_exists}",
		"userTotalScore" : "${modelUser.userTotalScore?if_exists}",
		"userBestScore" : "${modelUser.userBestScore?if_exists}",
		"userBestTime" : "${modelUser.userBestTime?if_exists}",
		"userBestRanking" : "${modelUser.userBestRanking?if_exists}",
		"userBestRankingTime" : "${modelUser.userBestRankingTime?if_exists}",
		"userWonCnt" : "${modelUser.userWonCnt?if_exists}",
		"userWonLineCnt" : "${modelUser.userWonLineCnt?if_exists}",
		"userBestWonLineCnt" : "${modelUser.userBestWonLineCnt?if_exists}",
		"userGlasses" : "${modelUser.userGlasses?if_exists}",
		"userNickname" : "${modelUser.userNickname?if_exists}",
		"userGender" : "${modelUser.userGender?if_exists}"
	</#if>
	}

}