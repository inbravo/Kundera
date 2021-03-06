/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.client.crud.compositeType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

/**
 * @author vivek.mishra
 * 
 */

@Entity
@Table(name = "CompositeUser")
@IndexCollection(columns = { @Index(name = "name") })
public class CassandraPrimeUser
{

    @EmbeddedId
    @OrderBy("key.tweetId ASC, key.timeLineId DESC")
    private CassandraCompoundKey key;

    @Column
    private String tweetBody;

    @Column
    private Date tweetDate;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private NickName nickName;

    public CassandraPrimeUser()
    {
    }

    public CassandraPrimeUser(CassandraCompoundKey key)
    {
        this.key = key;
    }

    /**
     * @return the key
     */
    public CassandraCompoundKey getKey()
    {
        return key;
    }

    /**
     * @return the tweetBody
     */
    public String getTweetBody()
    {
        return tweetBody;
    }

    /**
     * @return the tweetDate
     */
    public Date getTweetDate()
    {
        return tweetDate;
    }

    /**
     * @param tweetBody
     *            the tweetBody to set
     */
    public void setTweetBody(String tweetBody)
    {
        this.tweetBody = tweetBody;
    }

    /**
     * @param tweetDate
     *            the tweetDate to set
     */
    public void setTweetDate(Date tweetDate)
    {
        this.tweetDate = tweetDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public NickName getNickName()
    {
        return nickName;
    }

    public void setNickName(NickName nickName)
    {
        this.nickName = nickName;
    }

    enum NickName
    {
        KK, VM, AS;
    }
}
