package com.vic.camera.services;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashSet;
import java.util.Set;


@ServerEndpoint("/mensaje")
public class CameraSocket {

	private Set<Session> sessions = new HashSet<>();

	@OnOpen
	public void open(Session session) {
		System.out.println("Session opened ==>");
		sessions.add(session);
	}

	@OnMessage
	public String mensaje(String mensaje) {

		return "hola desde el servidor cámara el mensaje es :" + mensaje;
	}

	@OnClose
	public void close(Session session) {
		System.out.println("Session closed ==>");
		sessions.remove(session);
	}

	@OnError
	public void onError(Throwable e) {
		System.out.println(e.getMessage());
	}
}
