package classes;

import java.util.ArrayList;

public class Team {
	private ArrayList<User> members = new ArrayList<User>();
	
		
	public Team() {
		User test=new User("omid");
		members.add(test);
		members.add(test);
	}

	public String insertUser(String name) {
		User addUser=new User(name);
		members.add(addUser);
		return "200";
	}

	public String membercount() {
		return members.size() + "";
	}
	
	public String readTeamNames(String n) {
		int index=Integer.parseInt(n);
		String resualt="";
		try {
			resualt = members.get(index).getName();
		}catch (Exception e) {
			resualt=" ";
		}
		return resualt;
	}
	
	public String readTeamPowers(String name) {
		String resualt="";
		for(int i=0;i<this.members.size();i++){
	        if(this.members.get(i).getName().equals(name)){
	            resualt = members.get(i).getPower() + "";
	            break;
	        }
		}
		return resualt;
	}
	
	public String memberExist(String name) {
		String resualt = "404";
		for(int i=0;i<this.members.size();i++){
	        if(this.members.get(i).getName().equals(name)){
	            resualt = "200";
	            break;
	        }
		}
		return resualt;
	}
	public String getaveragePower(){
		int resualt=0;
		for (int i=0; i < members.size(); i++) {
			resualt = resualt + members.get(i).getPower();
		}
		resualt=resualt/members.size();
		return (resualt) + "";
	}
	
	public String insertPower(String name,int add) {
		for(int i=0;i<this.members.size();i++){
	        if(this.members.get(i).getName().equals(name)){
	            members.get(i).powerChange(add);
	            return "200";
	        }
		}
		return "404";
	}
	
	public String getUserPower(String name) {
		String resualt="";
		for(int i=0;i<this.members.size();i++){
	        if(this.members.get(i).getName().equals(name)){
	            resualt=members.get(i).getPower()+"";
	        }
		}
		return resualt;
	}
	
}
