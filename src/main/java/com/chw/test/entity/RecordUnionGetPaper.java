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
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RecordUnionGetPaper extends Model<RecordUnionGetPaper> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer seconds;

    private Long getTime;

    private Integer getCount;

    private Long avgGetTime;

    private Long getJdbcTime;

    private Integer getJdbcCount;

    private Long avgJdbcGetTime;

    private LocalDateTime creatTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
