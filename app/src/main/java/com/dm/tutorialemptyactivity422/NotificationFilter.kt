import android.app.Notification
import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

class NotificationFilter : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification) {
        // process notification
        val notification: Notification = sbn.notification
        val packageName: String = sbn.packageName
        val text: CharSequence? = notification.extras.getCharSequence(Notification.EXTRA_TEXT)

        if (text?.contains("record") == true || packageName == "com.google.android.apps.photos") {
            cancelNotification(sbn.key)
        }
    }
}
