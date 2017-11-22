package com.designmodern.chain;

import java.util.List;

public class Chain {

	//存放handler,保持对应的顺序
	private List<Handler> chainHandler;
	
	//当前handler的指针
	private int index;

	public List<Handler> getChainHandler() {
		return chainHandler;
	}

	public void setChainHandler(List<Handler> chainHandler) {
		this.chainHandler = chainHandler;
	}
	
	public Chain(List<Handler> chain){
		this.chainHandler=chain;
		this.index=0;
	}
	
	public void proceed(){
		if(index<chainHandler.size()){
			chainHandler.get(index++).execute(this);
		}
	}
	
}
