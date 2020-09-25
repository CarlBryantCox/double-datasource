package com.chw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenWei
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordUnionAll extends Model<RecordUnionAll> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer seconds;

    private Integer qps;

    private Integer getCount;

    private Long getJdbcTime;

    private Integer getJdbcCount;

    private Long avgJdbcGetTime;

    private LocalDateTime creatTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
