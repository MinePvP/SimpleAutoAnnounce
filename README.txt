== Simple Auto Announce ==

Easy handling for Automatic Broadcast Messages. You can set / add Messages in the Config ore InGame. The Messages will be send over a Time Interval (Default 10 Minutes) to all Online Players.


=== Message Formation ===

Message:
  - 'This is a Normal Announce for all Players in all Worlds'  -> 8.00am
  - '@world This is a Announce for all Players who are on the World world' -> 8.10am
  - '@world_nether This is a Message at the same time as the upper Message' -> 8.10am
  - ')' // This is a Bracke and says there is no other Message for this Time
  - 'Announce an normal Announcement' -> 8.20am
  - 'Next Announce' -> 8.30am
  - '!kill reini' -> 8.40am
  - 'Announcement for all People' -> 8.40am
  - ')'
  - 'Announcement' -> 8.50am


=== Commands ===
*/announce help
*/announce help settings
*/announce add
*/announce delete
*/announce list
*/announce settings

=== Colors ===
*<black>
*<dark_blue>
*<dark_green>
*<dark_aqua>
*<dark_red>
*<dark_purple>
*<gold>
*<gray>
*<dark_gray>
*<blue>
*<green>
*<aqua>
*<red>
*<light_purple>
*<yellow>
*<white>

=== Language ===
* English (Default)
* German

You can add your own Language! Copy the en_US.yml file to 
yourLanguage.yml and Change the Messages in the the File.

Then change the Conifig local to your new FileName witouht 
the ending (.yml)

=== Permissions ===
* **announce.add**  // for add messages
* **announce.delete** // for delete messages
* **announce.list** // for list all messages
* **announce.settings** // to change the settings
* **announce.admin** // all permissions in one

=== Next Implementations ===
* Better Spout Notification
* You have a Nice Feature Idea for this Plugin?

=== Changelog ===
==== Version 0.7.1 ====
* Bugfix when no Message
==== Version 0.7 ====
* update for 1.3.*
* add Command /announce force <message id> to force a Message
* add Simple Random Messages
* add Metrics Stats ( http://metrics.griefcraft.com/plugin/SimpleAutoAnnouncer )
==== Version 0.6 ====
* add easy way to add your own Language
==== Version 0.5.2 ====
* remove the announce ":" now you can add your own
* works with Craftbukkit-1.2.3-R0
==== Version 0.5.1 ====
* works with Craftbukkit-1.1-R4
==== Version 0.5 ====
* add Commands as a Message
* add diffrent World Messages
==== Version 0.4.1 ====
* fix German <-> English
==== Version 0.4 ====
* better Spout Notification
* bug fix when no SpoutPlugin installed
* other small stuff for Multi-Language
* add Command Alias /saa
==== Version 0.3 ====
* add simple Spout Notification
* add Multi-Language (German and English)
* fix some Bugs
==== Version 0.2 ====
* add InGame Settings
==== Version 0.1 ====
* Initial Releas