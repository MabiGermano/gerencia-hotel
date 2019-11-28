package com.br.ifpe.hosp3.util;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.br.ifpe.hosp3.view.TelaPrincipal;
public class TratadorEventos implements InternalFrameListener {
	TelaPrincipal telaPrincipal;
	
	public TratadorEventos() {
		
	}
	public TratadorEventos(TelaPrincipal desktop) {
		this.telaPrincipal = desktop;
	}
	@Override
	public void internalFrameActivated(InternalFrameEvent arg0) {
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent arg0) {
		telaPrincipal.executeBtnVisible();
			
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent arg0) {
		
	}

}
