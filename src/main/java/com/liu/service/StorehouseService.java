package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/20 17:29
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.Storehouse;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameStorehouseVo;

import java.util.List;

public interface StorehouseService extends IService<Storehouse> {

    //查找游戏
    Storehouse gameStorehouseExist(Integer userId,Integer gameId);

    //添加游戏
    void insertGame(RequestBuyGameVo requestBuyGameVo);

    //游戏仓库
    List<ResponseUserGameStorehouseVo> getGameStorehouseById(Integer id);

}
