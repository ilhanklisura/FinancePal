package com.example.financepal.ui.theme.screen

object SettingsDestination : NavigationDestination {
    override val route = "settings"
    override val title = "Settings"
}

object ChangePasswordDestination : NavigationDestination {
    override val route = "change_password"
    override val title = "Change Password"
}

object PrivacySettingsDestination : NavigationDestination {
    override val route = "privacy_settings"
    override val title = "Privacy Settings"
}

object NotificationSettingsDestination : NavigationDestination {
    override val route = "notification_settings"
    override val title = "Notification Settings"
}
