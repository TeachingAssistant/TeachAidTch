package com.gdufs.allen.teachaidtch.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;

/**
 * @author Allen Lin
 * @date 2016-1-21
 * @desc 检查网络是否连接
 */
public class NetworkUtil {

	public final static int NONE = 0;
	public final static int WIFI = 1;
	public final static int MOBILE = 2;

	public static int getNetworkState(Context context) {

		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		State state = connManager.getNetworkInfo(
				ConnectivityManager.TYPE_MOBILE).getState();
		if (state == State.CONNECTED || state == State.CONNECTING) {
			return MOBILE;
		}
		state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.getState();
		if (state == State.CONNECTED || state == State.CONNECTING) {
			return WIFI;
		}
		return NONE;
	}
}
