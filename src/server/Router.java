package server;

import server.Server;

public class Router {
	public static String routeing(String route,String content) {
		String resualt="";
		switch (route) {
		case "insertUser":
			resualt = insertUser(content);
			break;
		
		case "readFirstTeamNames":
			resualt = Server.firstTeam.readTeamNames(content);
			break;
			
		case "readSecondTeamNames":
			resualt = Server.secondTeam.readTeamNames(content);
			break;
			
		case "readTeamPowers":
			resualt = readTeamPowers(content);
			break;
			
		case "firstTeamMembersCount":
			resualt = Server.firstTeam.membercount();
			break;
			
		case "secondTeamMembersCount":
			resualt = Server.secondTeam.membercount();
			break;
			
		case "getUserPower":
			resualt = getUserPower(content);
			break;
			
		case "insertPower":
			resualt = insertpower(content,5);
			break;
			
		case "lessPower":
			resualt= insertpower(content, -5);
			
		case "finishOrNot":
			resualt = finishOrNot();
			break;
			
		case "winner":
			resualt = winner();
			break;

		case "WinnerOrNot":
			resualt = WinnerOrNot(content);
			break;
			
		case "readEnemyPowers":
			resualt=readEnemyPowers(content);
		}
		return resualt;
	}
	
	private static String readEnemyPowers(String content) {
		if(Server.firstTeam.memberExist(content).equals("404")){
			return  Server.firstTeam.getaveragePower();
		}
		return Server.secondTeam.getaveragePower();	
	}

	private static String finishOrNot() {
		int first=Integer.parseInt(Server.firstTeam.getaveragePower()),
			second=Integer.parseInt(Server.secondTeam.getaveragePower());
		if( (first*2 == second) || (second*2 == first) )
			return "1";
		return "0";
	}

	private static String WinnerOrNot(String content) {
		String memberIn,resualt,winner;
		winner=winner();
		
		if (Server.firstTeam.memberExist(content).equals("200")) {
			memberIn="first";
		}else {
			memberIn="second";
		}
		
		if (winner.equals("=")) {
			return "=";
		}else if (memberIn.equals(winner)) {
			resualt="win";
		}else {
			resualt="lose";
		}
		return resualt;
	}

	private static String winner() {
		String resualt;
		float first=Integer.parseInt(Server.firstTeam.getaveragePower()),
				second=Integer.parseInt(Server.secondTeam.getaveragePower());
		if (first>second) {
			resualt = "first";
		}else if(first==second) {
			resualt =  "=";
		}else {
			resualt = "second";
		}
		return resualt;
	}

	//------------------------------------SHOULD UPDATE !!!------------------------------------
	// private static String finishOrNot(){
		
	// 	return null;
	// }

	private static String insertpower(String content,int add) {
		if(Server.firstTeam.memberExist(content).equals("200")){
			return Server.firstTeam.insertPower(content, add);
		}
		return Server.secondTeam.insertPower(content, add);
	}

	private static String getUserPower(String content) {
		if (Server.firstTeam.memberExist(content).equals("200")) {
			return Server.firstTeam.getUserPower(content);
		}
		return Server.secondTeam.getUserPower(content);
	}

	private static String readTeamPowers(String content) {
		if(Server.firstTeam.memberExist(content).equals("200")){
			return  Server.firstTeam.getaveragePower();
		}
		return Server.secondTeam.getaveragePower();	
	}

	private static String insertUser(String content) {
		if(Integer.parseInt(Server.firstTeam.membercount()) > Integer.parseInt(Server.secondTeam.membercount())) {
			return Server.secondTeam.insertUser(content);
		}else{
			return  Server.firstTeam.insertUser(content);
		}
	}
}
