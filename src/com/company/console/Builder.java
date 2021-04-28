package com.company.console;


import com.company.administrator.Administrator;
import com.company.console.actions.*;
import com.company.console.items.MenuItem;

public class Builder {
	private Administrator administrator;

	public Builder(Administrator administrator){
		this.administrator=administrator;
	}
	private Menu rootMenu;

	public void buildMenu() {
		Menu rootMenu = new Menu();
		rootMenu.setName("Root Menu Options:");

		MenuItem CreateRoom= new MenuItem("CreateRoom", new CreateRoom(administrator), rootMenu);
		MenuItem AddClientToRoom = new MenuItem("AddClientToRoom", new AddClientToRoom(administrator), rootMenu);
		MenuItem PrintListOfRooms = new MenuItem("PrintListOfRooms", new PrintListOfRooms(administrator),rootMenu);
		MenuItem GetInfo= new MenuItem("Get info about room by ID", new GetInfoRoomById(administrator),rootMenu);
		MenuItem CreateService = new MenuItem("CreateService", new CreateService(administrator),rootMenu);
		MenuItem exit = new MenuItem("Exit", new ExitAction(), rootMenu);

		rootMenu.setMenuItems(new MenuItem[] { CreateRoom,CreateService,AddClientToRoom,PrintListOfRooms,GetInfo,exit});
		setRootMenu(rootMenu);
	}

	public Menu getRootMenu() {
		return rootMenu;
	}

	public void setRootMenu(Menu rootMenu) {
		this.rootMenu = rootMenu;
	}

}
