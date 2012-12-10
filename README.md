# Simple Auto Announce

Easy handling for Automatic Broadcast Messages. You can set / add Messages in the Config ore InGame. The Messages will be send over a Time Interval (Default 10 Minutes) to all Online Players.


## Message Formation
``
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
  - '#Staff This Message will send in the HeroChat Channel Staff' -> 9.00
  - '#Handel This Message will send in the HeroChat Channel Hanel' 9.00
  - ')'
  - '&permission.test This is a Message for Player who have the Permission <bold>permission.test'
  - '&permission.test.2 This is a <underline>Message<reset> for Player who have the Permission <bold>permission.test.2'
  - ')'
``

## Commands
- /announce help
- /announce help settings
- /announce add
- /announce force
- /announce delete
- /announce list
- /announce reload
- /announce settings

## Colors
- <black>
- <dark_blue>
- <dark_green>
- <dark_aqua>
- <dark_red>
- <dark_purple>
- <gold>
- <gray>
- <dark_gray>
- <blue>
- <green>
- <aqua>
- <red>
- <light_purple>
- <yellow>
- <white>

## TextSyles
- <bold>
- <underline>
- <italic>
- <strikethrough>
- <reset>

## Language
- English (Default)
- German
- French (thanks to Plumeex)
- Italien (thanks to Andreades)

You can add your own Language! Copy the en_US.yml file to 
yourLanguage.yml and Change the Messages in the the File.

Then change the Conifig local to your new FileName witouht 
the ending (.yml)

## Permissions
- **announce.add**  // for add messages
- **announce.delete** // for delete messages
- **announce.force** // for force a message
- **announce.list** // for list all messages
- **announce.reload** // for reload the configuration
- **announce.settings** // to change the settings
- **announce.admin** // all permissions in one

## Next Implementations
- You have a Nice Feature Idea for this Plugin?

## Changelog

###Version 0.9.2
* add Multiline Message Support
* works with Bukkit 1.4.5
* remove ugly Spout Support

### Version 0.9.1
* works with Bukkit 1.4.2
* fix reload command

### Version 0.9
* add Command Reload
* add Language French... thanks to Plumeex!
* add Language Italien... thanks to Andreades!
* add simple Permissions Support with "&announcer.test"
* fix some Language fails
* fix some Command Issues

### Version 0.8.1
* many Bugfixes!
* Settings add Random

### Version 0.8
* add HeroChat Channel Support
