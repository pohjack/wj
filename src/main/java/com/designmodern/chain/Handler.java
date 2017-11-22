package com.designmodern.chain;

/**
 * 责任链模式的一种实现方式
 * @author wj
 *
 */
public abstract class Handler {
	private Handler next;//指向下一个handler
	
	public Handler getNext(){
		return this.next;
	}
	
	public void setNext(Handler handler){
		this.next=handler;
	}
	
	/**
	 * 暴露给外部的方法，实现链式调用
	 */
	public void execute(){ 
		//先执行自身逻辑,之后调用下一个handler
		handlerProcess();
		if(next!=null){
			next.execute();
		}
	}
	/**
	 * 增加一个重载方法，用于责任链的第二种实现方式
	 * @param chain
	 */
	public void execute(Chain chain){ 
		//先执行自身逻辑,之后调用下一个handler
		handlerProcess();
		chain.proceed();
	}

	protected abstract void handlerProcess();//每个handler都必须实现这个抽象方法，实现对应的处理逻辑
}
