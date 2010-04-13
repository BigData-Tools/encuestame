/*
 ************************************************************************************
 * Copyright (C) 2001-2009 encuestame: system online surveys Copyright (C) 2009
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.core.persistence.dao.imp;

import java.util.List;

import org.encuestame.core.persistence.pojo.CatLocation;
import org.hibernate.HibernateException;
/**
 * Interface to implement Catalog Location Dao.
 * @author Picado, Juan juan@encuestame.org
 * @since  26/04/2009
 * @version $Id$
 */
public interface ICatLocation extends IBaseDao {

    /**
     * Find All Location.
     * @return list of all locations
     * @throws HibernateException hibernate
     */
    public List<CatLocation> findAll();


    /**
     * Find Location by Id.
     * @param locateId locate id
     * @return {@link CatLocation}
     * @throws HibernateException excetion
     */
    public CatLocation getLocationById(final Long locateId);

    /**
     * @param locateId locateId
     * @return aa
      * @throws HibernateException HibernateException
     */
    public List<CatLocation> getLocationbyLevelId(final Integer locateId);

    /**
     * @param tidtype tidtype
     * @return aa
     * @throws HibernateException HibernateException
     */
    public List<CatLocation> getLocationByTypeLocationId(final Long tidtype);

}