package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/20 17:30
 */


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.News;
import com.liu.entity.Storehouse;
import com.liu.mapper.StorehouseMapper;
import com.liu.service.StorehouseService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameStorehouseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class StorehouseServiceImpl extends ServiceImpl<StorehouseMapper, Storehouse> implements StorehouseService {

    @Autowired
    private StorehouseMapper storehouseMapper;

    //查找游戏
    @Override
    public Storehouse gameStorehouseExist(Integer userId, Integer gameId) {
        return storehouseMapper.gameStorehouseExist(userId,gameId);
    }

    //添加游戏
    @Override
    public void insertGame(RequestBuyGameVo requestBuyGameVo) {
        Storehouse storehouse = new Storehouse();
        BeanUtils.copyProperties(requestBuyGameVo,storehouse);
        Date date = new Date();
        storehouse.setBuyTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(storehouse);
    }

    //游戏仓库
    @Override
    public List<ResponseUserGameStorehouseVo> getGameStorehouseById(Integer id) {
        return storehouseMapper.getGameStorehouseById(id);
    }


}
