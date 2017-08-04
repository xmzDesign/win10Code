package cglibProxy;

public class Dao {
	
	public Dao() {
		update();
	}

	public void update(){
		System.out.println("PeopleDao.update()");
	}
	
	public void select(){
		System.out.println("PeopleDao.select()");
	}

}
