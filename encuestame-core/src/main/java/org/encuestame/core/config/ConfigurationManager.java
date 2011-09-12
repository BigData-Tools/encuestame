/*
 ************************************************************************************
 * Copyright (C) 2001-2011 encuestame: system online surveys Copyright (C) 2011
 * encuestame Development Team.
 * Licensed under the Apache Software License version 2.0
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to  in writing,  software  distributed
 * under the License is distributed  on  an  "AS IS"  BASIS,  WITHOUT  WARRANTIES  OR
 * CONDITIONS OF ANY KIND, either  express  or  implied.  See  the  License  for  the
 * specific language governing permissions and limitations under the License.
 ************************************************************************************
 */
package org.encuestame.core.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.encuestame.core.files.PathUtil;
import org.encuestame.core.service.DirectorySetupOperations;

/**
 * Configuration Manager.
 *
 * @author Picado, Juan juanATencuestame.org
 * @since Sep 4, 2011
 */
public class ConfigurationManager {

    /**
     * Log.
     */
    private static Log log = LogFactory.getLog(ConfigurationManager.class);

    /**
     * configuration store file.
     */
    private static XMLConfiguration xmlConfiguration = null;

    /**
     *
     * @param path
     * @throws ConfigurationException
     * @throws IOException
     */
    public ConfigurationManager(final File file) throws ConfigurationException, IOException {
        this.createConfiguration(file);
    }

    /**
     *
     * @param file
     * @throws ConfigurationException
     * @throws IOException
     */
    public ConfigurationManager(final String path) throws ConfigurationException, IOException {
        final File file = new File(path.toString());
        if (file.exists()) {
            this.createConfiguration(file);
        }
   }

    /**
     * Constructor.
     *
     * @throws IOException
     * @throws ConfigurationException
     */
    public ConfigurationManager() throws IOException, ConfigurationException {
        final File file = new File(buildConfigFilePath());
        if (file.exists()) {
            this.createConfiguration(file);
        }
    }

    private String buildConfigFilePath(){
        final StringBuffer stringBuffer = new StringBuffer(DirectorySetupOperations.getRootDirectory());
        stringBuffer.append(PathUtil.configFileName);
        return stringBuffer.toString();
    }

    /**
     *
     * @param file
     * @throws ConfigurationException
     */
    @SuppressWarnings("static-access")
    private void createConfiguration(final File file) throws ConfigurationException{
        log.debug("createConfiguration "+file.exists());
        if (file.exists()) {
            log.debug("createConfiguration.......... "+file);
            this.xmlConfiguration = new XMLConfiguration(file);
            this.xmlConfiguration.setAutoSave(true);
            this.xmlConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
        }
    }

    /**
     * @throws ConfigurationException
     *
     */
    public void reloadConfigFile(){
        log.debug("reloadConfigFile");
        final File file = new File(buildConfigFilePath());
        try {
            this.createConfiguration(file);
        } catch (ConfigurationException e) {
            e.printStackTrace();
            log.fatal(e);
            log.fatal("not able to reload configuration manager");
        }
    }

    /**
     *
     * @param property
     */
    public String getProperty(final String property) {
        return xmlConfiguration.getString(property);
    }

    /**
     *
     * @param property
     */
    public static Integer getIntProperty(final String String) {
        return xmlConfiguration.getInt(String);
    }

    /**
     * @param xmlConfiguration
     *            the xmlConfiguration to set
     */
    public void setXmlConfiguration(XMLConfiguration xmlConfiguration) {
        this.xmlConfiguration = xmlConfiguration;
    }

    /**
     *
     * @return
     */
    public Integer getDatabaseVersion(){
        return xmlConfiguration.getInt("database.version");
    }

    /**
    *
    * @return
    */
   public String getInstalledVersion(){
       return xmlConfiguration.getString("version");
   }

    /**
     * @return the xmlConfiguration
     */
    public XMLConfiguration getXmlConfiguration() {
        return xmlConfiguration;
    }
}
