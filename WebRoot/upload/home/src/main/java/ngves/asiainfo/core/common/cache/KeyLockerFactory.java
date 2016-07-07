/**
 * Copyright (c) 2010 asiainfo.com
 */
package ngves.asiainfo.core.common.cache;

import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过key值获取对应的锁的管理类<br/>
 * 该类为单例模式且为不可继承,访问权限包级-防止key值对应锁对象的滥用<br/>
 * 约定key值为为<code>String</code>类型
 * @author wzg
 *
 */
public final class KeyLockerFactory {
	
	//使用弱键哈希可以保证垃圾回收哈希表没有强引用的内容
	private WeakHashMap<String, Locker> lockerMap = new WeakHashMap<String, Locker>();
	
	private KeyLockerFactory(){
	}
	
	/**
	 * 私有静态内部类-用例进行工厂类单例的创建.
	 * @author wzg
	 *
	 */
	private static class KeyLockerFactoryLoader {
		private static final KeyLockerFactory keyLockerFactory = new KeyLockerFactory();
	}
	
	
	public static KeyLockerFactory getInstance() {
		return KeyLockerFactoryLoader.keyLockerFactory;
	}
	/**
	 * 公用静态内部类-只有类内可以实例化<br>
	 * 包级访问权限-只有成功标记可以更改
	 * @author wzg
	 *
	 */
	public static final class Locker {

		private Lock lock;
		private Locker() {
			this.lock = new ReentrantLock();
		}
		protected Lock getLock() {
			return lock;
		}
		
	}
	
	/**
	 * 根据key获取对应的锁,如果不存在添加一个对应锁
	 * @param key
	 * @return
	 */
	protected synchronized Locker acquire(String key) {
		Locker locker = lockerMap.get(key);
		if (locker == null) {
			locker = new Locker();
			lockerMap.put(key, locker);
		}
		return locker;
	} 
}
