-- Add board_id to table card
ALTER TABLE `atman`.`card` ADD COLUMN `board_id` INT(11) NOT NULL DEFAULT 0 AFTER `id`;
ALTER TABLE `atman`.`card` ADD INDEX `fk_board_id_idx` (`board_id` ASC);

UPDATE `atman`.`card` c, `atman`.`card_list` cl
SET c.board_id = cl.board_id WHERE c.card_list_id = cl.id;

ALTER TABLE `atman`.`card` ADD CONSTRAINT `fk_card_board_board_id`
  FOREIGN KEY (`board_id`)
  REFERENCES `atman`.`board` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

-- Change board_id to be nullable
ALTER TABLE `atman`.`activity` CHANGE COLUMN `board_id` `board_id` INT(11) NULL  COMMENT '' AFTER `card_id`;
-- Change type to support integer value other than 0, 1
ALTER TABLE `atman`.`activity` CHANGE COLUMN `type` `type` INT(11) NOT NULL COMMENT '' AFTER `board_id`;
-- Add `ip_address` to activity table
ALTER TABLE `atman`.`activity` ADD COLUMN `ip_address` VARCHAR(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' AFTER `detail`;

-- Change file_type to be a varchar
ALTER TABLE `atman`.`attachment` CHANGE COLUMN `file_type` `file_type` VARCHAR(32) NOT NULL DEFAULT ''  COMMENT '' AFTER `file_path`;
-- Add thumbnail_created to attachment
ALTER TABLE `atman`.`attachment` ADD COLUMN `thumbnail_created` TINYINT(1) NOT NULL DEFAULT 0 AFTER `file_type`;

-- Add `cover_image` to `card`
ALTER TABLE `atman`.`card` ADD COLUMN `cover_image` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL AFTER `position`;

