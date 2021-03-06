CREATE TABLE IF NOT EXISTS `clan_subpledges` (
  `clan_id` INT NOT NULL default '0',
  `sub_pledge_id` INT NOT NULL default '0',
  `name` varchar(45),
  `leader_id` INT NOT NULL default '0',
  PRIMARY KEY (`clan_id`,`sub_pledge_id`),
  FOREIGN KEY (`clan_id`) REFERENCES `clan_data`(`clan_id`) ON UPDATE CASCADE ON DELETE CASCADE
);