package com.icecream.springmybatiselement.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaohaotian
 * @since 2022-01-05
 */
@Data
  @EqualsAndHashCode(callSuper = false)
//  @Accessors(chain = true)
public class Book implements Serializable {

    private static final long serialVersionUID=1L;


    @TableId
    private String bookid;

    private String name;

    private BigDecimal price;


}
