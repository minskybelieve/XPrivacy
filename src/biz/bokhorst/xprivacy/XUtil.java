package biz.bokhorst.xprivacy;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.util.Log;

public class XUtil {
	public static final int LOG_DEBUG = Log.DEBUG;
	public static final int LOG_INFO = Log.INFO;
	public static final int LOG_WARNING = Log.WARN;
	public static final int LOG_ERROR = Log.ERROR;

	public static String getProcessNameByUid(Context context, int uid) {
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		if (manager != null) {
			List<RunningAppProcessInfo> lstProcess = manager.getRunningAppProcesses();
			if (lstProcess != null)
				for (RunningAppProcessInfo processInfo : lstProcess)
					if (processInfo.uid == uid)
						return processInfo.processName;
		}
		return null;
	}

	public static void log(XHook hook, int priority, String msg) {
		if (priority != LOG_DEBUG)
			if (hook == null)
				Log.println(priority, "XPrivacy", msg);
			else
				Log.println(priority, String.format("XPrivacy/%s", hook.getClass().getSimpleName()), msg);
	}
}
