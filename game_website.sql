/*
 Navicat Premium Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : game_website

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 07/02/2023 16:33:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `game_id` int(11) NULL DEFAULT NULL,
  `comment_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (4, 5, 1, '打卡打卡', '2022-08-21 20:12:52');
INSERT INTO `comment` VALUES (8, 2, 1, '鹿结局。。。', '2022-08-21 21:21:08');
INSERT INTO `comment` VALUES (9, 2, 3, '第一第一', '2022-08-21 21:21:34');
INSERT INTO `comment` VALUES (10, 3, 3, '第二（至尊VIP在此）', '2022-08-21 21:22:18');
INSERT INTO `comment` VALUES (11, 3, 31, '兄弟们，我是不是VIP', '2022-08-21 21:24:25');
INSERT INTO `comment` VALUES (16, 4, 33, '279拿下', '2022-08-27 14:45:42');
INSERT INTO `comment` VALUES (17, 4, 3, '不错不错', '2022-08-27 14:46:56');
INSERT INTO `comment` VALUES (18, 4, 15, '第一', '2022-08-27 14:47:31');
INSERT INTO `comment` VALUES (19, 4, 1, '111', '2022-08-27 14:52:32');
INSERT INTO `comment` VALUES (20, 2, 1, '1111', '2022-09-21 18:23:42');
INSERT INTO `comment` VALUES (34, 21, 1, '1', '2022-10-21 17:46:55');
INSERT INTO `comment` VALUES (35, 22, 3, '12', '2022-10-21 21:24:58');
INSERT INTO `comment` VALUES (36, 2, 1, '123123123', '2023-01-23 11:24:46');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名',
  `game_price` decimal(11, 2) NULL DEFAULT NULL COMMENT '游戏价格',
  `game_likes` int(11) NULL DEFAULT 0 COMMENT '游戏点赞数',
  `game_sales` int(11) NULL DEFAULT 0 COMMENT '游戏销量',
  `game_recommend` int(1) NULL DEFAULT 0 COMMENT '是否推荐(0：不推荐；1：推荐)',
  `game_exist` int(1) NULL DEFAULT 1 COMMENT '是否被下架(0：下架；1：上架)',
  `game_edition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏版本介绍',
  `game_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏介绍',
  `game_config_first` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏配置(操作系统)',
  `game_config_second` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏配置(处理器)',
  `game_config_third` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏配置(显卡)',
  `game_config_fourth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏配置(内存)',
  `game_config_fifth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏配置(存储空间)',
  `game_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏图片',
  `game_screenshot_first` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏截图(一)',
  `game_screenshot_second` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏截图(二)',
  `game_screenshot_third` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏截图(三)',
  `game_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏类型',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`game_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of game
-- ----------------------------
INSERT INTO `game` VALUES (1, '荒野大镖客2', 249.00, 10, 5, 1, 1, 'v1436.28终极版|容量119GB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器|赠雷霆内置修改器|赠音乐BGM|赠官方艺术画集|赠传说鱼任务.5件稀有小饰品.东部传说套装.全部护身符通关存档', '《荒野大镖客2(Red Dead Redemption 2)》是由Rockstar Games制作发行的一款开放世界动作冒险类游戏，是人气游戏《荒野大镖客》的最新续作。本作讲述在美国无情的蛮荒大地上绽放出的生命诗篇。游戏庞大又细腻的世界，也将是全新多人游戏模式体验的最佳舞台。', 'Windows 10', 'Intel® Core™ i5-2500K / AMD FX-6300', 'Nvidia GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB', '12 GB RAM', '需要 115 GB可用空间', '../img/game/RDR2.png', '../img/screenshot/RDR2-1.jpg', '../img/screenshot/RDR2-2.jpg', '../img/screenshot/RDR2-3.jpg', '角色扮演', '2022-08-08 12:00:00');
INSERT INTO `game` VALUES (2, '暗黑破坏神2：重制版/Diablo II: Resurrected', 258.00, 0, 0, 0, 1, 'v1.03.70409离线版|容量28.1GB|官方简体中文.国语配音|支持键盘.鼠标', '《暗黑破坏神2：重制版》包括所有来自《暗黑破坏神2》的四个章节及其资料片《暗黑破坏神2：毁灭之王》的一个章节。该资料片同时也有提供的全新内容，包括另外两个可扮演的职业全新物品符文和符文字词组合无形物品等。', 'Windows 10', 'AMD FX-4350', 'Nvidia GTX 660 或AMD Radeon HD 7850', '8 GB RAM', '需要 30 GB 可用空间', '../img/game/Diablo2.jpg', '../img/screenshot/Diablo2-1.jpg', '../img/screenshot/Diablo2-2.jpg', '../img/screenshot/Diablo2-3.jpg', '角色扮演', '2022-08-09 12:00:00');
INSERT INTO `game` VALUES (3, '极限竞速：地平线5 顶级版(+DLC)/Forza Horizon 5', 309.00, 4, 2, 1, 1, 'v1.488.996.0顶级版|容量121GB|官方简体中文|支持键盘.鼠标.手柄|赠全车·剧情全三星·精品环岛极速漂移调教·全探索·无限超级抽奖存档', '您的终极地平线冒险正等着您展开！探索墨西哥充满活力且不断变化的开放世界景色，驾驶百辆世界级好车，享受无拘无束又有趣的驾驶体验。这是您的地平线冒险在墨西哥充满活力并不断变化的开放世界景色中，驾驶百辆世界级好车，享受无拘无束又有趣的驾驶体验，并开始令人屏息的探险。这是多元化的开放世界探索景色反差悬殊、美丽无比的世界。发掘充满生气的沙漠、茂密的丛林、充满历史的城市、隐藏的废墟、原始的海滩、广大的峡谷和终年积雪的高耸火山。', 'Windows 10 version 15063.0 or higher', 'Intel i5-8400 or AMD Ryzen 5 1500X', 'NVidia GTX 1070 OR AMD RX 590', '16 GB RAM', '需要 110 GB 可用空间', '../img/game/ForzaHorizon5.jpg', '../img/screenshot/ForzaHorizon5-1.jpg', '../img/screenshot/ForzaHorizon5-2.jpg', '../img/screenshot/ForzaHorizon5-3.jpg', '竞速体育', '2022-08-08 13:00:00');
INSERT INTO `game` VALUES (4, '末日地带：与世隔绝', 29.00, 0, 0, 0, 1, 'v1.2.8244|容量7.74GB|官方简体中文|支持键盘.鼠标|赠原声音乐', '《末日地带：与世隔绝 》是一款末日生存题材的城市建造类游戏。你将带领人民在核爆之后的末世建立新文明。在破碎的世界中为他们建造家园，在频繁的辐射、酸雨、沙暴和干旱灾害中生存下来。', 'Windows 10 64-Bit', 'I5-2500K, 4-Cores @3.30 GHz or equivalent AMD-Hardware', 'GeForce GTX 760', '8 GB RAM', '需要 8 GB 可用空间', '../img/game/DoomsdayZone.jpg', '../img/screenshot/DoomsdayZone-1.jpg', '../img/screenshot/DoomsdayZone-2.jpg', '../img/screenshot/DoomsdayZone-3.jpg', '生存类型', '2022-08-08 05:00:00');
INSERT INTO `game` VALUES (5, '模拟人生4豪华版/The Sims4', 149.00, 1, 1, 0, 1, '模拟人生4豪华版/The Sims4', '《模拟人生4(The Sims 4)》是由Maxis/The Sims Studio联合制作，EA发行的一款模拟经营类游戏，是人气系列《模拟人生》的最新正统续作。游戏中玩家可以获得离线经验，打造个性化的世界，同时游戏将提供便捷的分享功能，把自己的模拟人生快速的分享给朋友。创造有着突出性格与鲜明外表的全新模拟市民。控制您的模拟市民的思想、身体及心灵，并体验不同的人生!', '64 Bit Windows 7 (SP1), 8, 8.1, or 10', 'Intel core i5 or faster, AMD Athlon X4', 'NVIDIA GTX 650 or better', '8 GB RAM', '需要 53.4 GB 可用空间', '../img/game/TheSims4.png', '../img/screenshot/TheSims4-1.jpg', '../img/screenshot/TheSims4-2.jpg', '../img/screenshot/TheSims4-3.jpg', '模拟经营', '2022-08-08 14:00:00');
INSERT INTO `game` VALUES (6, '龙珠：超宇宙2', 268.00, 0, 0, 0, 1, 'v1.18.00豪华版|容量25GB|官方简体中文|赠音乐原声|赠多项修改器|赠满级存档|赠4个MOD版(MOD人物1419个)', '《龙珠：超宇宙2(Dragonball XenoVerse 2)》是由QLOC,DIMPS制作，万代南宫梦发行的一款3D动作格斗类游戏，根据人气动漫《龙珠》改编而成。游戏讲述了多米库拉事件之后，依然持续发生的历史改变。时之界王神为了应付变化多端的历史改变而招募时空巡逻者。', 'Windows 7 and higher', 'Intel Core i5-3470, 3.20GHz | AMD FX-6300, 3.5Ghz', 'GeForce GT 660 | Radeon HD 7770', '4 GB RAM', '需要 25 GB 可用空间', '../img/game/DragonBall.png', '../img/screenshot/DragonBall-1.jpg', '../img/screenshot/DragonBall-2.jpg', '../img/screenshot/DragonBall-3.jpg', '格斗游戏', '2022-08-08 12:30:00');
INSERT INTO `game` VALUES (7, '切尔诺贝利人', 99.00, 0, 0, 0, 1, 'v48519增强版|容量35.1GB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器|赠壁纸|赠原声音乐', '恐怖生存游戏。玩家需要在一片核灾难后的废墟之中生存下来，面对各种被核辐射污染的生物，某些超自然现象', 'Windows 7 SP1 (x64), Windows 8 (x64), Windows 10 (x64)', 'Intel Core i7 4790k CPU', 'Geforce GTX 970 / GTX 1060 or AMD Radeon RX 480 / RX 570', '16 GB RAM', '需要 45 GB 可用空间', '../img/game/Chernobylite.jpg', '../img/screenshot/Chernobylite-1.jpg', '../img/screenshot/Chernobylite-2.jpg', '../img/screenshot/Chernobylite-3.jpg', '恐怖惊悚', '2022-08-05 12:00:00');
INSERT INTO `game` VALUES (8, '狙击精英V2重制版', 245.00, 0, 0, 0, 1, 'v1.0.13.2|容量33.6GB|官方简体中文|支持键盘.鼠标.手柄', '在《狙击精英V2重制版（Sniper Elite V2 Remastered）》中，你扮演精英狙击手卡尔·费尔伯恩，空降到德军展开背水一战的柏林。 当你被困在两支绝望的军队之间，而又必须争分夺秒时，潜行是关键所在。掌控逼真武器，偷偷接近目标，巩固阵地，调试射击并运用技能，耐心机智地完成任务。', 'Windows 7 SP1, 64-bit', 'AMD Ryzen 5 1500X or Intel CPU Core i7-3770', 'AMD Radeon RX570 or Nvidia GPU GeForce GTX 1070', '8 GB RAM', '需要 15 GB 可用空间', '../img/game/SniperEliteV2Remastered.jpg', '../img/screenshot/SniperEliteV2Remastered-1.jpg', '../img/screenshot/SniperEliteV2Remastered-2.jpg', '../img/screenshot/SniperEliteV2Remastered-3.jpg', '射击游戏', '2022-08-01 12:00:00');
INSERT INTO `game` VALUES (9, '孤山难越/Insurmountable', 45.00, 1, 1, 0, 1, 'v2.0.7.3|容量2.19GB|官方简体中文|支持键盘.鼠标', '作为孤独的攀登者，面对各种地形，忍受攀登的无数危险！你要在危险的环境中做出很多艰难的决定。上山下山，克服难以逾越的高度！', 'WINDOWS® 7, 8.1, 10 64-BIT', 'Intel® Core™ i7-3770, AMD FX™-9590, or better', 'NVIDIA® GeForce® GTX 970 with 6GB VRAM, AMD Radeon™ RX 480 with 8GB VRAM, or better', '8 GB RAM', '需要 4 GB 可用空间', '../img/game/Insurmountable.jpg', '../img/screenshot/Insurmountable-1.jpg', '../img/screenshot/Insurmountable-2.jpg', '../img/screenshot/Insurmountable-3.jpg', '即时战略', '2022-08-08 21:00:00');
INSERT INTO `game` VALUES (10, '哥布林弹球/Peglin', 46.00, 0, 1, 0, 1, 'v0.7.17|容量262MB|官方简体中文|支持键盘.鼠标.手柄', 'Peglin是一款柏青哥式的Roguelike游戏 – 使用收集的各式弹珠，碰撞钉子来对敌人造成伤害。获得独特的遗物则会大幅度改变游戏机制，每次游玩都有新体验。请小心地调整射击方向，尽力在这款独特的回合制RPG中生存下去吧！', 'Windows 7', '2.0GHz', 'Integrated Graphics', '2048 MB RAM', '需要 300 MB 可用空间', '../img/game/Peglin.jpg', '../img/screenshot/Peglin-1.jpg', '../img/screenshot/Peglin-2.jpg', '../img/screenshot/Peglin-3.jpg', '休闲游戏', '2022-08-08 21:10:00');
INSERT INTO `game` VALUES (11, '艾尔登法环', 400.00, 1, 0, 1, 1, 'v1.05豪华版|容量50.9GB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器|赠CE修改器+汉化CT|赠一周目完美初始开局存档.全武器+全战灰+全魔法+全护甲服装+全祈祷+全护符+全护盾+全骨灰', '《Elden Ring》是一款黑暗幻想类的动作角色扮演游戏。该作更加注重RPG元素，继续保持高难度，玩家将体验到战胜困难所带来的乐趣。在Elden Ring的世界里充斥着危险和威胁，有很多地方等待探索。玩家会见到一些错综复杂的地图设计，充满层次感的城堡，以及许多类似的要素。', 'Windows 10', 'INTEL CORE I5-8400 or AMD RYZEN 3 3300X', 'NVIDIA GEFORCE GTX 1060 3 GB or AMD RADEON RX 580 4 GB', '12 GB RAM', '需要 60 GB 可用空间', '../img/game/EldenRing.jpg', '../img/screenshot/EldenRing-1.jpg', '../img/screenshot/EldenRing-2.jpg', '../img/screenshot/EldenRing-3.jpg', '角色扮演', '2022-07-31 21:10:00');
INSERT INTO `game` VALUES (12, '巫师3：狂猎年度版', 158.00, 1, 0, 1, 1, 'v1.32|集成18DLC+血与酒+石之心|容量49GB|支持键盘.鼠标.手柄|官方简体中文|赠官方原声60首BGM|赠多项修改器|赠通关存档|外送30MOD合集|赠中文PDF游戏攻略|巫师世界官方设定集', '《巫师：狂猎》是一款情节驱动的开放世界角色扮演游戏。本作的故事发生在一个令人目眩神迷的奇幻宇宙里，玩家做出的每一个选择都意义重大，同时也要面对影响深远的后果。在《巫师》这个广袤的开放世界中，您可以尽情探索商业都市、海盗岛屿、危险的山隘和被遗忘的洞窟。', 'Windows 7 / 8 / 10 (仅支持64位)', 'Intel CPU Core i5 2500K 3.3GHz / AMD Phenom II X4 940', 'Nvidia GeForce GTX 660 / AMD Radeon HD 7870', '6 GB RAM', '需要 44 GB 可用空间', '../img/game/TheWitcher3.png', '../img/screenshot/TheWitcher3-1.jpg', '../img/screenshot/TheWitcher3-2.jpg', '../img/screenshot/TheWitcher3-3.jpg', '角色扮演', '2022-07-31 10:15:10');
INSERT INTO `game` VALUES (13, '赛博朋克2077', 298.00, 0, 0, 1, 1, 'v1.52|容量69GB|官方简体中文.国语发音|支持键盘.鼠标|赠多项修改器|赠原声BGM|赠原画集', '《赛博朋克 2077》是一款开放世界游戏，故事发生在夜之城，权力更迭和身体改造是这里不变的主题。扮演一名野心勃勃的雇佣兵：V，追寻一种独一无二的植入体——获得永生的关键。自定义角色义体、技能和玩法，探索包罗万象的城市。您做出的选择也将会对剧情和周遭世界产生影响。', 'Windows 10', 'Intel Core i5-3570K or AMD FX-8310', 'NVIDIA GeForce GTX 780 or AMD Radeon RX 470', '8 GB RAM', '需要 70 GB 可用空间', '../img/game/Cyberpunk2077.png', '../img/screenshot/Cyberpunk2077-1.jpg', '../img/screenshot/Cyberpunk2077-2.jpg', '../img/screenshot/Cyberpunk2077-3.jpg', '角色扮演', '2022-07-29 15:15:30');
INSERT INTO `game` VALUES (14, '求生之路2', 37.00, 1, 0, 1, 1, '版本介绍：Build20210218网络联机版|容量18GB|官方简体中文|支持键盘.鼠标.手柄|赠求生之路1|赠网络联机教程', '《求生之路2(Left 4 Dead 2)》是由Valve制作发行的一款以僵尸大灾难为背景的第一人称FPS游戏，是人气游戏《求生之路》的最新续作。游戏将带领你和你的好友穿过城市，沼泽，深入南部的墓地，从沙凡那港市到新奥尔良，沿途经过 5 个漫长的战役。 你会扮演四名新生还者中的一名，装备有大量先进的武器。', 'Windows 7 32/64-bit / Vista 32/64 / XP', 'Intel core 2 duo 2.4GHz', 'Video Card Shader model 3.0. NVidia 7600, ATI X1600 or better', '2 GB RAM', '需要 6 GB 可用空间', '../img/game/Left4Dead2.png', '../img/screenshot/Left4Dead2-1.jpg', '../img/screenshot/Left4Dead2-2.jpg', '../img/screenshot/Left4Dead2-3.jpg', '恐怖惊悚', '2022-07-31 12:30:00');
INSERT INTO `game` VALUES (15, '消逝的光芒2：人与仁之战', 299.00, 0, 1, 1, 1, 'v1.4.2终极版|整合全DLC|容量84.6GB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器|赠单板未加密补丁', '病毒获胜了，文明退回了黑暗时代。作为人类最后的堡垒之一，“都市”正处在崩溃的边缘。运用你的敏捷和战斗技巧活下去，并重塑这个世界。你的选择意义重大。', 'Windows 10', 'AMD / Intel CPU running at 3.6 GHz or higher: AMD Ryzen 5 3600X or Intel i5-8600K', 'NVIDIA GeForce RTX 2060 6GB or AMD RX Vega 56 8GB', '16 GB RAM', '需要 60 GB 可用空间', '../img/game/DyingLight2StayHuman.png', '../img/screenshot/DyingLight2StayHuman-1.jpg', '../img/screenshot/DyingLight2StayHuman-2.jpg', '../img/screenshot/DyingLight2StayHuman-3.jpg', '角色扮演', '2022-08-01 18:15:26');
INSERT INTO `game` VALUES (16, '末日准备狂', 70.00, 1, 2, 1, 1, 'v1.25d|容量4GB|官方简体中文|支持键盘.鼠标', '末日准备狂。时刻为世界末日做着准备。你总是感觉到有点不对劲，你可以嗅到空气中弥漫着核战争即将到来的味道，你必须为核战后的世界末日做好准备', 'Windows 8/7/Vista/XP', '3.2 GHz Dual Core Processor', 'NVIDIA GeForce 520M or Intel HD 4000 | DirectX 版本: 9.0c', '4 GB RAM', '需要 6 GB 可用空间', '../img/game/MrPrepper.jpg', '../img/screenshot/MrPrepper-1.jpg', '../img/screenshot/MrPrepper-2.jpg', '../img/screenshot/MrPrepper-3.jpg', '模拟经营', '2022-08-01 19:15:00');
INSERT INTO `game` VALUES (17, '任天堂明星大乱斗', 300.00, 0, 0, 1, 1, 'v13.0.1_99DLCs_yuzuEA2613|容量20GB|官方简体中文|支持键盘.鼠标.手柄', '《任天堂明星大乱斗特别版》是Nintendo旗下的《任天堂明星大乱斗》系列发售在的Switch平台的全新作品，本作支持繁体中文和简体中文。该系列拥有丰富的玩法和别具一格，既能让人轻松上手，也有值得品味的深度，任天堂的粉丝们一定不要错过。', 'Windows 10 (64 bit)', 'Intel Core i7 9700  @ 3.4 GHz', 'Nvidia GeForce GTX 960', '16 GB RAM', '需要 30 GB 可用空间', '../img/game/SuperSmashBros.jpg', '../img/screenshot/SuperSmashBros-1.jpg', '../img/screenshot/SuperSmashBros-2.jpg', '../img/screenshot/SuperSmashBros-3.jpg', '格斗游戏', '2022-08-02 12:35:10');
INSERT INTO `game` VALUES (18, '往日不再', 279.00, 0, 1, 1, 1, 'v1.06|容量59.8GB|官方繁体中文|支持键盘.鼠标.手柄|赠多项修改器|赠外送完全通关存档|赠官方原画设定集|赠音乐原声', '《往日不再》游戏采用完全开放世界的设计，任何玩家在游玩过程中看到的地区都是可以进行探索的地方！由于地图相当庞大，帮助玩家移动的摩托车便非常重要。游戏设定在美国东北部的虚拟战场，主人公圣约翰执事是一名摩托车帮的前成员。', 'Windows 10 64-bits', 'Intel Core i7-4770K@3.5GHz or Ryzen 5 1500X@3.5GHz', 'Nvidia GeForce GTX 1060 (6 GB) or AMD Radeon RX 580 (8 GB)', '16 GB RAM', '需要 70 GB 可用空间', '../img/game/DaysGone.jpg', '../img/screenshot/DaysGone-1.jpg', '../img/screenshot/DaysGone-2.jpg', '../img/screenshot/DaysGone-3.jpg', '角色扮演', '2022-08-01 18:20:00');
INSERT INTO `game` VALUES (19, '超级炸弹人R', 126.00, 0, 0, 0, 1, '版本介绍：超级炸弹人R|v2.1.1版|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器  注意事项：【不支持双人对战】', '《超级炸弹人R(Super Bomberman R)》是一款由HexaDrive制作Konami发行的动作类游戏。玩家控制的角色在一个2D环境中进行游戏。玩家需要布置陷阱和炸弹来击败对手。', 'Windows 7 / 8.1 / 10', 'Intel Core i3 2GHz or faster processor', 'Intel HD Graphics 3000 | DirectX 版本: 9.0c', '4 GB RAM', '需要 6 GB 可用空间', '../img/game/SuperBombermanR.png', '../img/screenshot/SuperBombermanR-1.jpg', '../img/screenshot/SuperBombermanR-2.jpg', '../img/screenshot/SuperBombermanR-3.jpg', '休闲游戏', '2022-08-14 14:13:45');
INSERT INTO `game` VALUES (20, '大凤羽空与刻之剑/COGEN: Sword of Rewind', 141.00, 0, 0, 0, 1, 'v20220126|容量473MB|官方简体中文|支持键盘.鼠标.手柄', '回溯时光，前进。 回到死亡3秒前突破障碍，全新2D动作游戏在此登场。', 'Windows 10', 'core i5-7200U', 'Intel HD Graphics 620', '8 GB RAM', '需要 500 MB 可用空间', '../img/game/COGEN.jpg', '../img/screenshot/COGEN-1.jpg', '../img/screenshot/COGEN-2.jpg', '../img/screenshot/COGEN-3.jpg', '休闲游戏', '2022-08-14 14:21:22');
INSERT INTO `game` VALUES (21, '怪物猎人物语2：毁灭之翼', 396.00, 0, 0, 0, 1, 'v1.5.3单机+联机版|容量26.7GB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器', '一个新的冒险等待着你在这个回合为基础的RPG系列设置在怪物猎人世界的第二部分！成为一个骑手，并形成与朋友的怪物称为怪物的纽带，以与他们并肩作战，因为你在一个史诗故事的一部分。', 'WINDOWS® 10 (64-BIT Required)', 'Intel® Core™ i5-9400F 3.20 GHz', 'NVIDIA®GeForce® GTX 1060 / 2GB VRAM', '4 GB RAM', '需要 28 GB 可用空间', '../img/game/MonsterHunterStories2.jpg', '../img/screenshot/MonsterHunterStories2-1.jpg', '../img/screenshot/MonsterHunterStories2-2.jpg', '../img/screenshot/MonsterHunterStories2-3.jpg', '生存类型', '2022-08-14 15:47:16');
INSERT INTO `game` VALUES (22, 'F1 2020/单机/同屏多人', 163.00, 1, 1, 0, 1, '版本介绍：v1.18_Build20211001|容量46GB|官方简体中文|支持键盘.鼠标.手柄', '玩家能够通过生涯模式中新增的“My Team”模式来组建自己的车队，包括车手，挑选赞助商和引擎提供商，以及雇佣队友等等。另外本地双人分屏模式也同样在本作中回归。', '64 bit Windows 10', 'Intel Core i5 9600K / AMD Ryzen 5 2600X', 'NVIDIA GTX 1660 Ti / AMD RX 590 (DirectX12 Graphics Card)', '16 GB RAM', '需要 80 GB 可用空间', '../img/game/F12020.jpg', '../img/screenshot/F12020-1.png', '../img/screenshot/F12020-2.png', '../img/screenshot/F12020-3.png', '竞速体育', '2022-08-14 15:47:29');
INSERT INTO `game` VALUES (23, '王国风云3/十字军之王3/Crusader Kings III', 53.00, 0, 1, 0, 1, 'v1.6.1.2联机版|集成DLCs|容量8.43GB|官方简体中文|支持键盘.鼠标', 'Paradox Development Studio 即将推出史上最受欢迎策略游戏之一的系列续作。《Crusader Kings III》承袭了昔日渊远流长的大战略游戏体验，并带来许多能确保您王室家族取得胜利的新手段。', 'Windows® 8.1 64 bit / Windows® 10 Home 64 bit', 'Intel® Core™ i3-2120 / AMD® FX 6350', 'Nvidia® GeForce™ GTX 460 (1GB) / AMD® Radeon™ HD 7870 (2GB) / Intel® Iris Pro™ 580 / Intel® Iris® Plus G7 / AMD® Radeon™ Vega 11', '6 GB RAM', '需要 8 GB 可用空间', '../img/game/CrusaderKingsIII.png', '../img/screenshot/CrusaderKingsIII-1.jpg', '../img/screenshot/CrusaderKingsIII-2.jpg', '../img/screenshot/CrusaderKingsIII-3.jpg', '即时战略', '2022-08-14 15:48:26');
INSERT INTO `game` VALUES (24, '古墓丽影11：暗影 克劳馥版', 368.00, 1, 1, 0, 1, 'v1.0.458.0终极版.最终版|容量40GB|官方简体中文.国语配音|支持键盘.鼠标.手柄|赠38套衣服.全武器.7个通道技能全开.全DLC爆关.全收集存档', '《古墓丽影：暗影（Shadow of the Tomb Raider）》是由Eidos-Montréal, Crystal Dynamics制作，Square Enix发行的一款动作冒险游戏，本作为人气系列《古墓丽影》的第十一部正统续作，也是《古墓丽影》系列重启后的第三部作品。这一作古墓丽影的风格将与之前的作品完全不同，劳拉也将会实现自我的蜕变，迎来关键性的时刻，用尽所有的力量，成为真正的“古墓丽影”。', 'Windows 10 64-bit', 'Intel Core i7 4770K, 3.40 Ghz or AMD Ryzen 5 1600, 3.20 Ghz', 'Nvidia GTX 1060 6GB or AMD Radeon RX 480, 8GB', '16 GB RAM', '需要 40 GB 可用空间', '../img/game/ShadowOfTheTombRaider.png', '../img/screenshot/ShadowOfTheTombRaider-1.jpg', '../img/screenshot/ShadowOfTheTombRaider-2.jpg', '../img/screenshot/ShadowOfTheTombRaider-3.jpg', '射击游戏', '2022-08-14 16:12:02');
INSERT INTO `game` VALUES (25, '穿越火线：军团/Crossfire: Legion', 81.00, 0, 0, 0, 1, 'v1.1|容量9.04GB|官方简体中文|支持键盘.鼠标', 'Crossfire: Legion是一款实时战略游戏，故事发生在不久的未来，世界已经支离破碎，到处都是激烈的战斗和战术行动。组建和定制自己的军队，参与激烈的联机战斗，一路过关斩将，不断晋升。穿越火线军团', 'Windows 10 64bit', 'Intel(R) Core(TM) i5-4460 or AMD equivalent', 'GeForce GTX 960 or AMD equivalent, 4 GB VRAM', '8 GB RAM', '需要 8 GB 可用空间', '../img/game/CrossfireLegion.jpg', '../img/screenshot/CrossfireLegion-1.jpg', '../img/screenshot/CrossfireLegion-2.jpg', '../img/screenshot/CrossfireLegion-3.jpg', '即时战略', '2022-08-14 16:12:31');
INSERT INTO `game` VALUES (26, '只狼：影逝二度', 268.00, 0, 1, 1, 1, 'v1.06版|容量15GB|官方简体中文|支持键盘.鼠标.手柄|赠官方原声4首BGM|赠多项修改器|赠一周目全义手忍具强化通关存档', '《只狼：影逝二度(Sekiro：Shadows Die Twice)》是一款由From Software制作Activision发行的第三人称视角的动作冒险沙盒类游戏，玩家将操控一位忍者，拯救他的主人—拥有日本贵族血统的大能的皇子，并向他的天敌复仇。游戏背景设立于16世纪末的日本战国，主角是在血腥冲突中濒临死亡边缘下登场的一匹独狼。玩家将面对的敌人是既恐怖又巨大的各种日本妖魔鬼怪，不过借助强大的忍者技能可以让我们无声潜行、勾索滑行各个场景，还可以一对一与这些怪兽搏斗。 ', 'Windows 7、8、10（64bit）', 'Intel i5-2500K or  Ryzen 5 1400', 'NVIDIA GeForce GTX 1060 3GB / AMD Radeon RX 580 4GB', '8 GB RAM', '需要 30 GB 可用空间', '../img/game/Sekiro.png', '../img/screenshot/Sekiro-1.jpg', '../img/screenshot/Sekiro-2.jpg', '../img/screenshot/Sekiro-3.jpg', '格斗游戏', '2022-08-14 16:13:29');
INSERT INTO `game` VALUES (27, '僵尸毁灭工程/Project Zomboid', 48.00, 0, 1, 1, 1, 'v41.55|容量4.5GB|官方简体中文|支持键盘.鼠标|赠作弊码', '游戏《僵尸毁灭工程》中充满着诡异和压抑的气氛,除了在房内短暂停留,和在外与僵尸群拼斗以外,主角会经常奔跑在漆黑的雨夜,收集、打造物品和工具，拯救危难中的女友,生存下去,等待阳光的降临… 这是个开发中的游戏,从官网上的言论来看,似乎催促者很多,作者不堪其扰,放出了开发中的版本. 游戏充满着诡异和压抑的气氛,除了在房内短暂停留,和在外与僵尸群拼斗以外,主角会经常奔跑在漆黑的雨夜,收集、打造物品和工具，拯救危难中的女友,生存下去,等待阳光的降临', 'Windows XP, Vista, 7', 'Intel 2.77GHz Quad Core', 'Dedicated graphics card with 1 GB of RAM minimum and GLSL 1.2 support', '4 GB RAM', '需要 4.5 GB 可用空间', '../img/game/ProjectZomboid.png', '../img/screenshot/ProjectZomboid-1.jpg', '../img/screenshot/ProjectZomboid-2.jpg', '../img/screenshot/ProjectZomboid-3.jpg', '恐怖惊悚', '2022-08-14 16:17:22');
INSERT INTO `game` VALUES (28, '泰拉瑞亚/Terraria/支持 单机.网络联机', 36.00, 1, 1, 1, 1, 'v1.4.3.6单机+v1.4.3.2联机版|容量443MB|官方简体中文|支持键盘.鼠标.手柄|赠多项修改器', '《泰拉瑞亚》是由Re-Logic公司开发的一款高自由度的沙盒游戏，于2011年5月16日在PC上发行。玩家可以在游戏中做很多事情：制造武器战胜各种各样的敌人及群落；挖掘地下寻找器材配件、金钱和其他有用的东西；收集木材，石材，矿石等资源；用世界里的一切创造你需要的东西并守护它。', 'Windows Xp，Vista，7', '1.6 Ghz', '128 MB 显存，能够运行 Shader Model 1.1', '512 MB RAM', '需要 443MB 可用空间', '../img/game/Terraria.jpg', '../img/screenshot/Terraria-1.jpg', '../img/screenshot/Terraria-2.jpg', '../img/screenshot/Terraria-3.jpg', '生存类型', '2022-08-14 16:18:44');
INSERT INTO `game` VALUES (29, '美国卡车模拟/American Truck Simulator', 99.00, 0, 1, 0, 1, 'v1.44.1.22s单机+v1.44.1.22s联机版|整合全DLC|容量8.96GB|官方简体中文|支持键盘.鼠标.手柄', '《美国卡车模拟(American Truck Simulator)》是由SCSSoftware制作发行的一款模拟运输游戏。游戏中玩家需要驾驶美式卡车运输货物，过程中要保证遵守交通规则，保持匀速行驶，按时交货等等，还要靠自己的驾驶技术把货车精确的停到货仓。游戏中中使用的地图为谷歌地图，玩家可以驾驶各式各样的美式卡车，在高速公路上欣赏北美的标志性建筑。', 'Windows 7/8.1/10 64-bit', 'Quad core CPU 3.0 GHz', 'GeForce GTX 760-class (2 GB)', '6 GB RAM', '需要 10 GB 可用空间', '../img/game/AmericanTruckSimulator.png', '../img/screenshot/AmericanTruckSimulator-1.jpg', '../img/screenshot/AmericanTruckSimulator-2.jpg', '../img/screenshot/AmericanTruckSimulator-3.jpg', '模拟经营', '2022-08-14 16:18:54');
INSERT INTO `game` VALUES (30, '极限竞速：地平线4/Forza Horizon 4', 188.00, 2, 0, 1, 1, 'v1.476.400.0|容量95GB|官方简体中文|赠车辆解锁存档.700多辆车.500多涂装.乐高.财富岛通关', '在世界上最盛大的汽车嘉年华上，不断变化的赛季改变着一切。单枪匹马或者与其他人组队，在一个共享开放世界中探索美丽而富有历史气息的英国。收集、改装和驾驶超过 450 辆车辆。尽情竞速、表演特技、创造和探索：选择您专属的方式来成为地平线中的超级巨星。', 'Windows 10 version 15063.0 or higher', 'Intel i7-3820 @ 3.6Ghz', 'NVidia GTX 970 OR NVidia GTX 1060 3GB OR AMD R9 290x OR AMD RX 470', '8 GB RAM', '需要 95 GB 可用空间', '../img/game/dipinxian.jpg', '../img/screenshot/dipinxian-1.jpg', '../img/screenshot/dipinxian-2.jpg', '../img/screenshot/dipinxian-3.jpg', '竞速体育', '2022-08-14 16:59:23');
INSERT INTO `game` VALUES (31, '鬼泣5/Devil May Cry 5', 383.00, 0, 2, 1, 1, '整合DMC5维吉尔Vergil-全DLC豪华版，追加可游玩Vergil的游戏模式。', '最强的恶魔猎人强势回归！动作游戏迷翘首以待，传说中的Stylish Action《Devil May Cry》终于復活！', 'WINDOWS® 7 / WINDOWS® 8.1 / WINDOWS® 10 (64-BIT Required)', 'Intel® Core™ i7-3770, AMD FX™-9590, or better', 'NVIDIA® GeForce® GTX 1060 with 6GB VRAM, AMD Radeon™ RX 480 with 8GB VRAM, or better', '8 GB RAM', '需要 35 GB 可用空间', '../img/game/DevilMayCry5.jpg', '../img/screenshot/DevilMayCry5-1.jpg', '../img/screenshot/DevilMayCry5-2.jpg', '../img/screenshot/DevilMayCry5-3.jpg', '格斗游戏', '2022-08-15 21:16:26');
INSERT INTO `game` VALUES (32, '双人成行/It Takes Two', 148.00, 1, 3, 0, 1, '中文版|容量43.6GB|官方简体中文|支持键盘.鼠标.手柄', '游玩《双人成行》，踏上生命中最疯狂的旅程。利用好友通行证*邀请一位好友免费游玩，共同体验多种多样的乐趣，享受颠覆性的玩法挑战。', 'Windows 8.1 64-bit or Windows 10 64-bit', 'Intel Core i5 3570K or AMD Ryzen 3 1300x', 'Nvidia GeForce GTX 980 or AMD R9 290X', '8 GB RAM', '需要 44 GB 可用空间', '../img/game/ItTakesTwo.jpg', '../img/screenshot/ItTakesTwo-1.jpg', '../img/screenshot/ItTakesTwo-2.jpg', '../img/screenshot/ItTakesTwo-3.jpg', '休闲游戏', '2022-08-15 21:41:59');
INSERT INTO `game` VALUES (33, '战神4/God of War', 279.00, 1, 2, 1, 1, 'v1.0.12|容量61.8GB|官方繁体中文|支持键盘.鼠标.手柄|赠多项修改器|赠完美装备符文全收集存档|赠Win7/Win8系统支持补丁|赠3DM简中汉化补丁v1.1', '在这部《战神》新作中玩家将开启一段全新的旅程，主角奎托斯将来到其不曾熟悉的土地，遭遇未知的威胁，并且将再次成为一名父亲。其将和自己的儿子Atreus一起在荒蛮的北欧之地展开一场为完成个人的使命而战斗。', 'Windows 10 64-bit', 'Intel i5-2500k(4core 3.3 GHz)、AMD Ryzen 3 1200(4 core 3.1 GHz)', 'NVIDIA GTX960(4GB)、AMD R9 290X(4GB)', '8 GB RAM', '需要 70 GB 可用空间', '../img/game/GodOfWar.png', '../img/screenshot/GodOfWar-1.jpg', '../img/screenshot/GodOfWar-2.jpg', '../img/screenshot/GodOfWar-3.jpg', '格斗游戏', '2022-08-15 21:50:05');
INSERT INTO `game` VALUES (34, '塞尔达传说：荒野之息/旷野之息', 400.00, 3, 9, 0, 1, 'v20210903_Cemu1.22.13b_v1.5.0|容量20GB|官方简体中文|支持键盘.鼠标.手柄|内置可选物品道具解锁通关存档|赠音乐原声.海量电子攻略等附件集', '《塞尔达传说：旷野之息(The Legend of Zelda：Breath of the wild)》是由任天堂制作发行的一款角色扮演游戏，是人气系列《塞尔达传说》的最新正统续作。本作采用开放世界的设定，拥有无缝切换的战斗场景。游戏地图规模是《黄昏公主》的12倍，另外地图并非“大而无当”，演示中所有可见的山脉、障碍都可以攀爬，而且地图设计十分立体，会在各种绝地发现别有洞天。', 'Windows 7/8.1/10', 'Intel Core i3', 'GTX750Ti', '4 GB RAM', '需要 20 GB 可用空间', '../img/game/TheLegendOfZelda.png', '../img/screenshot/TheLegendOfZelda-1.jpg', '../img/screenshot/TheLegendOfZelda-2.jpg', '../img/screenshot/TheLegendOfZelda-3.jpg', '角色扮演', '2022-08-15 21:55:58');
INSERT INTO `game` VALUES (39, '真三国无双8：帝国', 100.00, 0, 0, 1, 1, '中文版|容量40GB|官方简体中文|支持键盘.鼠标', '《真三国无双8：帝国》并不只是《真三8》的增强版，本作被介绍为是一款“战术动作”游戏。本作中“帝国”系列特色之一的充满战略性的战斗大幅进化为“攻城战”，以城池周边区域为舞台，率领军队夺取城池。在时刻变化的战况中灵活运用各种计谋或是自身的武力设法攻下城门。', 'win10', 'Intel Core i5 4460', 'NVIDIA GeForce GTX 1650', '6 GB RAM', '需要 50 GB 可用空间', '../img/game/sanguo8.jpg', '../img/screenshot/sanguo8-1.jpg', '../img/screenshot/sanguo8-3.jpg', '../img/screenshot/sanguo8-3.jpg', '角色扮演', '2022-10-21 17:50:22');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `likes_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `game_id` int(11) NULL DEFAULT NULL,
  `likes_time` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`likes_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 72 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (3, 2, 12, '2022-08-21 14:44:50');
INSERT INTO `likes` VALUES (9, 2, 30, '2022-08-21 14:58:06');
INSERT INTO `likes` VALUES (16, 3, 1, '2022-08-21 21:25:17');
INSERT INTO `likes` VALUES (18, 2, 16, '2022-08-24 14:35:26');
INSERT INTO `likes` VALUES (19, 2, 33, '2022-08-24 14:36:24');
INSERT INTO `likes` VALUES (20, 2, 5, '2022-08-24 14:36:31');
INSERT INTO `likes` VALUES (21, 2, 24, '2022-08-24 14:36:41');
INSERT INTO `likes` VALUES (23, 2, 14, '2022-08-26 09:20:14');
INSERT INTO `likes` VALUES (24, 2, 3, '2022-09-23 15:05:36');
INSERT INTO `likes` VALUES (25, 2, 32, '2022-10-04 11:24:35');
INSERT INTO `likes` VALUES (39, 2, 9, '2022-10-20 19:08:39');
INSERT INTO `likes` VALUES (66, 21, 1, '2022-10-21 17:46:52');
INSERT INTO `likes` VALUES (67, 22, 3, '2022-10-21 21:24:45');
INSERT INTO `likes` VALUES (68, 2, 34, '2022-11-04 20:51:18');
INSERT INTO `likes` VALUES (71, 2, 1, '2023-01-23 11:24:36');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_type` int(1) NULL DEFAULT NULL COMMENT '推送类型(1：购买游戏；2：充值；3：开通VIP)',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '接收者',
  `game_id` int(11) NULL DEFAULT NULL COMMENT '购买的游戏',
  `recharge` decimal(11, 0) NULL DEFAULT NULL COMMENT '充值的金额',
  `send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, 2, 2, NULL, 100, '2022-08-24 21:46:30');
INSERT INTO `news` VALUES (2, 1, 2, 28, NULL, '2022-08-24 22:07:00');
INSERT INTO `news` VALUES (3, 1, 6, 16, NULL, '2022-08-24 22:11:32');
INSERT INTO `news` VALUES (4, 1, 2, 27, NULL, '2022-08-25 11:25:57');
INSERT INTO `news` VALUES (5, 2, 2, NULL, 100, '2022-08-25 11:26:58');
INSERT INTO `news` VALUES (6, 1, 2, 9, NULL, '2022-08-25 11:30:37');
INSERT INTO `news` VALUES (7, 1, 2, 23, NULL, '2022-08-25 11:33:11');
INSERT INTO `news` VALUES (9, 2, 2, NULL, 100, '2022-08-25 14:50:57');
INSERT INTO `news` VALUES (10, 2, 2, NULL, 50, '2022-08-25 14:55:58');
INSERT INTO `news` VALUES (11, 2, 2, NULL, 50, '2022-08-25 14:56:28');
INSERT INTO `news` VALUES (12, 2, 2, NULL, 50, '2022-08-25 14:56:56');
INSERT INTO `news` VALUES (14, 2, 2, NULL, 100, '2022-08-25 15:14:12');
INSERT INTO `news` VALUES (15, 2, 2, NULL, 20, '2022-08-25 15:19:23');
INSERT INTO `news` VALUES (16, 2, 2, NULL, 12, '2022-08-25 15:20:52');
INSERT INTO `news` VALUES (17, 2, 2, NULL, 100, '2022-08-25 15:36:11');
INSERT INTO `news` VALUES (22, 3, 2, NULL, NULL, '2022-08-25 18:32:59');
INSERT INTO `news` VALUES (23, 2, 2, NULL, 50, '2022-08-25 18:47:22');
INSERT INTO `news` VALUES (24, 2, 2, NULL, 50, '2022-08-28 15:14:12');
INSERT INTO `news` VALUES (25, 2, 2, NULL, 50, '2022-09-21 18:23:59');
INSERT INTO `news` VALUES (26, 1, 2, 16, NULL, '2022-09-22 14:19:11');
INSERT INTO `news` VALUES (27, 2, 2, NULL, 10, '2022-09-22 14:24:21');
INSERT INTO `news` VALUES (32, 2, 2, NULL, 500, '2022-09-23 17:22:50');
INSERT INTO `news` VALUES (33, 1, 2, 32, NULL, '2022-10-04 11:24:19');
INSERT INTO `news` VALUES (36, 1, 2, 33, NULL, '2022-10-09 21:35:33');
INSERT INTO `news` VALUES (37, 2, 2, NULL, 500, '2022-10-09 21:36:21');
INSERT INTO `news` VALUES (38, 1, 2, 34, NULL, '2022-10-09 21:36:30');
INSERT INTO `news` VALUES (66, 2, 2, NULL, 200, '2022-10-21 17:12:33');
INSERT INTO `news` VALUES (67, 2, 21, NULL, 500, '2022-10-21 17:48:23');
INSERT INTO `news` VALUES (68, 2, 21, NULL, 100, '2022-10-21 17:48:31');
INSERT INTO `news` VALUES (69, 3, 21, NULL, NULL, '2022-10-21 17:48:46');
INSERT INTO `news` VALUES (70, 2, 21, NULL, 500, '2022-10-21 17:49:06');
INSERT INTO `news` VALUES (71, 1, 21, 1, NULL, '2022-10-21 17:49:12');
INSERT INTO `news` VALUES (72, 1, 2, 3, NULL, '2022-11-04 21:00:27');

-- ----------------------------
-- Table structure for storehouse
-- ----------------------------
DROP TABLE IF EXISTS `storehouse`;
CREATE TABLE `storehouse`  (
  `storehouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `game_id` int(11) NULL DEFAULT NULL,
  `buy_time` datetime(0) NULL DEFAULT NULL COMMENT '购买时间',
  PRIMARY KEY (`storehouse_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storehouse
-- ----------------------------
INSERT INTO `storehouse` VALUES (1, 6, 1, '2022-08-20 19:05:51');
INSERT INTO `storehouse` VALUES (2, 6, 3, '2022-08-21 11:11:22');
INSERT INTO `storehouse` VALUES (3, 6, 26, '2022-08-21 11:15:13');
INSERT INTO `storehouse` VALUES (4, 6, 29, '2022-08-21 11:16:26');
INSERT INTO `storehouse` VALUES (5, 6, 31, '2022-08-21 11:21:52');
INSERT INTO `storehouse` VALUES (6, 6, 18, '2022-08-21 11:24:03');
INSERT INTO `storehouse` VALUES (7, 6, 15, '2022-08-21 12:54:59');
INSERT INTO `storehouse` VALUES (8, 6, 5, '2022-08-24 14:41:04');
INSERT INTO `storehouse` VALUES (9, 6, 24, '2022-08-24 14:41:19');
INSERT INTO `storehouse` VALUES (10, 6, 10, '2022-08-24 14:41:28');
INSERT INTO `storehouse` VALUES (11, 6, 22, '2022-08-24 14:41:40');
INSERT INTO `storehouse` VALUES (12, 2, 28, '2022-08-24 22:07:00');
INSERT INTO `storehouse` VALUES (13, 6, 16, '2022-08-24 22:11:32');
INSERT INTO `storehouse` VALUES (14, 2, 27, '2022-08-25 11:25:57');
INSERT INTO `storehouse` VALUES (15, 2, 9, '2022-08-25 11:30:37');
INSERT INTO `storehouse` VALUES (16, 2, 23, '2022-08-25 11:33:11');
INSERT INTO `storehouse` VALUES (21, 2, 1, '2022-08-25 18:32:59');
INSERT INTO `storehouse` VALUES (22, 2, 16, '2022-09-22 14:19:11');
INSERT INTO `storehouse` VALUES (23, 2, 32, '2022-10-04 11:24:19');
INSERT INTO `storehouse` VALUES (25, 2, 33, '2022-10-09 21:35:33');
INSERT INTO `storehouse` VALUES (26, 2, 34, '2022-10-09 21:36:30');
INSERT INTO `storehouse` VALUES (37, 21, 34, '2022-10-21 17:48:46');
INSERT INTO `storehouse` VALUES (38, 21, 1, '2022-10-21 17:49:12');
INSERT INTO `storehouse` VALUES (39, 2, 3, '2022-11-04 21:00:27');

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `strategy_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `strategy_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略标题',
  `strategy_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略内容',
  `strategy_game` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '攻略游戏',
  `strategy_pass` int(1) NULL DEFAULT 0 COMMENT '是否通过审核(0：审核中；1：通过；2：未通过)',
  `strategy_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`strategy_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES (1, 5, '艾尔登法环索尔城怎么去', '索尔城在雪山，不开雪山去不了，玩家可以穿过上图的大桥之后下坡就到索尔城了。不需要开升降机，雪山地图是需要你打完噩兆 然后城里中间大路有一头是个很大的门 推开一直往前探索就到升降机然后就可以去雪山了。玩家在古遗迹降雪谷出发，一路向前，走到有破旧小屋的位置左转，做上升气流上来之后再左转，上面就是桥。', '艾尔登法环', 1, '2022-08-16 10:17:34');
INSERT INTO `strategy` VALUES (2, 4, '荒野大镖客2怎么决斗', '游戏中故事模式的决斗，一共只有十一场决斗，分别来自主线剧情，随机遭遇和陌生人事件。拯救误入邪教的男孩，需要射掉他手中的枪。决斗不要长按左键蓄力，会很慢，正确做法是快速连续点击鼠标左键，差不多连着点两次左键就会出死眼。', '荒野大镖客2', 0, '2022-08-16 10:30:54');
INSERT INTO `strategy` VALUES (3, 4, '战神4传送门怎么用', '战神4游玩主线剧情的时候是无法使用传送门的，根据剧情，传送门会适时开放。本作中的快速移动是通过设置在各个地区的魔法门完成的。当奎爷从矮人手里获得对应的道具之后就能使用。要注意，传送门需要发现之后才会被激活。', '战神4', 1, '2022-08-16 10:34:06');
INSERT INTO `strategy` VALUES (4, 4, '饥荒肉丸怎么做', '制作肉丸需要准备0.5个肉度，小肉、大肉、怪物肉和三个填充物，可以是浆果、水果、蔬菜，各种素食。但是不能添加树枝，不然会变成骨肉相连，蜂蜜也不行，会变成蜜汁烤肉。点开烹饪锅，把材料放入后就能烹饪了。肉丸可以恢复3点生命，62点饱食度，5点理智，烹饪过程需要15秒，保鲜期为10天。', '饥荒', 0, '2022-08-16 10:35:07');
INSERT INTO `strategy` VALUES (5, 4, '艾尔登法环隐形怪怎么打', '1、西面海岸边，石柱附近有只隐形的怪，可以看到它的脚印在飞速前进。预判它的行进路线在脚印到来时攻击就能斩杀。2、隐形怪除了看不到身形以外没有什么特殊的地方，击杀也很简单，好点的装备基本都是两刀解决，击杀成功得到战灰：箭步(回旋斩)。', '艾尔登法环', 1, '2022-08-16 10:36:15');
INSERT INTO `strategy` VALUES (6, 4, '艾尔登法环怎么转职', '游戏中并没有明确的转职这一设定，基本上是由玩家自己在游玩过程中对各属性的加点引导向某个流派。类似转职的只有洗点，需要先击败学院地区的满月女王，击败该BOSS后即可以在她这里洗点，洗点需要消耗泪滴幼体。泪滴幼体有很多的获取途径，比如在亚基尔湖南方赐福的东边，由一个伪装成不死士兵的小符文熊掉落。在白金村，可以在城镇的墓地中找到。可以在希芙拉河，以3000卢恩在见弃商人处购买。在盖利德的南边，由一个伪装成不死士兵的巨人掉落。在永恒之城诺克隆恩一个石头建筑内的尸体上找到等等。', '艾尔登法环', 0, '2022-08-16 10:42:51');
INSERT INTO `strategy` VALUES (7, 4, '泰拉瑞亚风暴之颚怎么获得', '在游戏泰拉瑞亚灾厄模组中，风暴之颚是一种困难模式前掉落自沙漠中的风暴蚁狮的合成材料。它用于制作召唤荒漠灾虫的荒漠吊坠和旋风发射器武器。灾厄mod是由外国mod制作人大山猪MountainDrew制作的mod，因其制作初期极其生草游戏性强，对原版有大量扩充，世界观完善和boss强大而闻名。灾厄mod中新增了4种模式，复仇、死亡、神殇、末日。新增1种挑战铁心。新增23种boss，3500件以上 物品，新职业盗贼。该mod中boss的特色是弹幕密集，对走位要求极高，建议原版基础非常好的玩家尝试。', '泰拉瑞亚', 2, '2022-08-16 10:43:46');
INSERT INTO `strategy` VALUES (8, 4, '艾尔登法环怎么暗杀', '首先玩家需要装备一个能够把人抡死或者捅死的武器，只要不是法杖就好。然后按下X，蹲下，悄悄接近要暗杀的目标。在他的后面锁定，对准，按下左键，手柄是R1。在学习战技学习暗杀办法后装备，可以使用暗杀办法消除脚步声，靠近怪物也不会被发现。暗杀办法需要加入火焰官邸势力完成任意火山委托后，从叛律者贝纳尔处购买。', '艾尔登法环', 2, '2022-08-16 10:45:45');
INSERT INTO `strategy` VALUES (9, 4, '巫师3孤岩秘密宝藏怎么拿', '在游戏《巫师3》中，孤岩的宝藏位于断桥下水中的洞口里，玩家进入洞口的方法是直接从断桥处直接跳到洞口，也可以下水慢慢游过去，洞口内没有怪物可以直接获得孤岩的宝藏。', '巫师3', 1, '2022-08-16 10:46:41');
INSERT INTO `strategy` VALUES (10, 4, '失落的方舟狗粮怎么获得', '1、游戏中打开拍卖行，搜索狗粮，接着找到需要的商品点击直接购买即可获得。2、在混沌副本的混沌地牢中可以获得。3、在幽灵船佩顿门口915分以上可以获得。4、通过藏宝图可以获得。5、通过命运之塔也可以获得一次。6、公会血石兑换以及PVP商店兑换。7、各个港口商船的海盗币兑换以及临时活动岛屿也可以获得。', '失落的方舟', 1, '2022-08-16 10:48:11');
INSERT INTO `strategy` VALUES (11, 5, '饥荒蓝鲸的遗体怎么打开', '在发现鲸鱼的遗体之后，玩家需要先等待大概3至5天，鲸鱼的尸体就会冒出黑烟，意味着尸体开始慢慢腐烂，在这个过程中，它会慢慢变大，此时玩家可以用武器攻击。等到鲸鱼尸体完全腐烂后，它就会爆炸掉落出相应的物品。', '饥荒：联机版', 1, '2022-08-16 10:50:31');
INSERT INTO `strategy` VALUES (17, 4, '1', '1', '1', 2, '2022-08-27 12:18:08');
INSERT INTO `strategy` VALUES (18, 4, '2', '2', '2', 1, '2022-08-27 12:18:12');
INSERT INTO `strategy` VALUES (19, 4, '3', '3', '3', 2, '2022-08-27 12:18:15');
INSERT INTO `strategy` VALUES (28, 21, '1', '1', '1', 0, '2022-10-21 17:47:25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_money` decimal(11, 2) NULL DEFAULT NULL COMMENT '用户余额',
  `user_identity` int(1) NULL DEFAULT 1 COMMENT '(0：VIP，1：非VIP)',
  `user_type` int(1) NULL DEFAULT 1 COMMENT '(0：管理员，1：用户)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `ban_time` datetime(0) NULL DEFAULT NULL COMMENT '封禁时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', '123', '202cb962ac59075b964b07152d234b70', 0.00, 1, 0, '2022-07-31 11:51:50', NULL);
INSERT INTO `user` VALUES (2, '测试用户一号', '1', 'c4ca4238a0b923820dcc509a6f75849b', 95.00, 0, 1, '2022-07-31 11:51:50', NULL);
INSERT INTO `user` VALUES (3, '测试用户二号', '2', 'c81e728d9d4c2f636f067f89cc14862c', 0.00, 0, 1, '2022-07-31 11:51:50', NULL);
INSERT INTO `user` VALUES (4, '攻略用户三号', '3', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', 0.00, 1, 1, '2022-08-16 10:27:00', NULL);
INSERT INTO `user` VALUES (5, '攻略用户四号', '4', 'a87ff679a2f3e71d9181a67b7542122c', 0.00, 0, 1, '2022-08-16 10:27:31', NULL);
INSERT INTO `user` VALUES (6, '游戏购买五号', '5', 'e4da3b7fbbce2345d7772b0674a318d5', 17567.00, 0, 1, '2022-08-21 11:09:42', NULL);
INSERT INTO `user` VALUES (21, '刘同学', '2456867076', '4297f44b13955235245b2497399d7a93', 351.00, 0, 1, '2022-10-21 17:46:08', NULL);
INSERT INTO `user` VALUES (22, '揭同学', '2122815010', 'e10adc3949ba59abbe56e057f20f883e', 0.00, 1, 1, '2022-10-21 21:23:42', NULL);

SET FOREIGN_KEY_CHECKS = 1;
