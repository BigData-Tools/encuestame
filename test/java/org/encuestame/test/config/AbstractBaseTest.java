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
package org.encuestame.test.config;

import java.util.Date;

import org.encuestame.core.persistence.dao.ClientDao;
import org.encuestame.core.persistence.dao.TweetPollDao;
import org.encuestame.core.persistence.dao.imp.ICatLocation;
import org.encuestame.core.persistence.dao.imp.ICatLocationTypeDao;
import org.encuestame.core.persistence.dao.imp.ICatState;
import org.encuestame.core.persistence.dao.imp.IClientDao;
import org.encuestame.core.persistence.dao.imp.IPoll;
import org.encuestame.core.persistence.dao.imp.IProject;
import org.encuestame.core.persistence.dao.imp.IQuestionDao;
import org.encuestame.core.persistence.dao.imp.ISecGroups;
import org.encuestame.core.persistence.dao.imp.ISecPermissionDao;
import org.encuestame.core.persistence.dao.imp.ISecUserDao;
import org.encuestame.core.persistence.dao.imp.ISurvey;
import org.encuestame.core.persistence.dao.imp.ISurveyFormatDao;
import org.encuestame.core.persistence.dao.imp.ITweetPoll;
import org.encuestame.core.persistence.pojo.CatLocation;
import org.encuestame.core.persistence.pojo.CatLocationType;
import org.encuestame.core.persistence.pojo.CatState;
import org.encuestame.core.persistence.pojo.Client;
import org.encuestame.core.persistence.pojo.Poll;
import org.encuestame.core.persistence.pojo.PollResult;
import org.encuestame.core.persistence.pojo.Project;
import org.encuestame.core.persistence.pojo.QuestionColettion;
import org.encuestame.core.persistence.pojo.Questions;
import org.encuestame.core.persistence.pojo.QuestionPattern;
import org.encuestame.core.persistence.pojo.QuestionsAnswers;
import org.encuestame.core.persistence.pojo.SecGroups;
import org.encuestame.core.persistence.pojo.SecPermission;
import org.encuestame.core.persistence.pojo.SecUserSecondary;
import org.encuestame.core.persistence.pojo.SecUsers;
import org.encuestame.core.persistence.pojo.SurveyFormat;
import org.encuestame.core.persistence.pojo.SurveyGroup;
import org.encuestame.core.persistence.pojo.TweetPoll;
import org.encuestame.core.persistence.pojo.TweetPollResult;
import org.encuestame.core.persistence.pojo.TweetPollSwitch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base Class to Test Cases.
 * @author Picado, Juan juan@encuestame.org
 * @since October 15, 2009
 * @version $Id$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager" ,defaultRollback = true)
@Transactional
@Scope("singleton")
@ContextConfiguration(locations = {
        "classpath:encuestame-service-context.xml",
        "classpath:encuestame-dao-context.xml",
        "classpath:encuestame-beans-jsf-context.xml",
        "classpath:encuestame-hibernate-context.xml",
        "classpath:encuestame-email-context.xml",
        "classpath:encuestame-param-test-context.xml",
        "classpath:encuestame-security-context.xml"
         })
public class AbstractBaseTest extends AbstractTransactionalDataSourceSpringContextTests {

     /** SurveyFormat  Dao.**/
    @Autowired
    private ISurveyFormatDao surveyformatDaoImp;

    /** CatLocation  Dao.**/
    //   @Autowired
    //  private ICatLocation catLocation;

    /** State Catalog Dao.**/
    @Autowired
    private ICatState catStateDaoImp;

    /** User Security Dao.**/
    @Autowired
    private ISecUserDao secUserDao;

    /**Group Security Dao.**/
    @Autowired
    private ISecGroups secGroupDaoImp;

    /** Security Permissions Dao.**/
    @Autowired
    private ISecPermissionDao secPermissionDaoImp;

    /** Catalog Location Dao.**/
    @Autowired
    private ICatLocation catLocationDao;

    /** Project Dao Imp.**/
    @Autowired
    private IProject projectDaoImp;

    /** Survey Dao Imp.**/
    @Autowired
    private ISurvey surveyDaoImp;

    /** Question Dao Imp.**/
    @Autowired
    private IQuestionDao questionDaoImp;

    /** Catalog Location Type Dao.**/
    @Autowired
    private ICatLocationTypeDao catLocationTypeDao;

    /** {@link ClientDao}. **/
    @Autowired
    private IClientDao clientDao;

    /** {@link TweetPollDao}. **/
    @Autowired
    private ITweetPoll iTweetPoll;

    @Autowired
    private IPoll iPoll;

      /** Activate Notifications.**/
    private Boolean activateNotifications = false;


    /**
     * Getter.
     * @return the surveyFormatDaoImp
     */
    public ISurveyFormatDao getSurveyFormatDaoImp() {
        return surveyformatDaoImp;
    }

    /**
     * @param surveyformatDaoImp {@link ISurveyFormatDao}
     */
    public void setSurveyFormatDaoImp(final ISurveyFormatDao surveyformatDaoImp) {
        this.surveyformatDaoImp = surveyformatDaoImp;
    }


    /**
     * Getter.
     * @return the catStateDaoImp
     */
    public ICatState getCatStateDaoImp() {
        return catStateDaoImp;
    }

    /**
     * @param catStateDaoImp the catStateDaoImp to set
     */
    public void setCatStateDaoImp(final ICatState catStateDaoImp) {
        this.catStateDaoImp = catStateDaoImp;
    }

    /**
     * @return the userDao
     */
    public ISecUserDao getSecUserDao() {
        return secUserDao;
    }

    /**
     * @param userDao the userDao to set
     */
    public void setSecUserDao(final ISecUserDao userDao) {
        this.secUserDao = userDao;
    }

    /**
     * @return {@link ISecGroups}
     */
    public ISecGroups getSecGroup(){
        return secGroupDaoImp;
    }

    /**
     * @param secGroupDaoImp  {@link ISecGroups}
     */
    public void setgroupDao(final ISecGroups secGroupDaoImp){
        this.secGroupDaoImp = secGroupDaoImp;
    }

    /**
     * @return the secPermissionDaoImp
     */
    public ISecPermissionDao getSecPermissionDaoImp() {
        return secPermissionDaoImp;
    }

    /**
     * @param secPermissionDaoImp the secPermissionDaoImp to set
     */
    public void setSecPermissionDaoImp(final ISecPermissionDao secPermissionDaoImp) {
        this.secPermissionDaoImp = secPermissionDaoImp;
    }

    /**
     * @return the secGroupDaoImp
     */
    public ISecGroups getSecGroupDaoImp() {
        return secGroupDaoImp;
    }

    /**
     * @param secGroupDaoImp the secGroupDaoImp to set
     */
    public void setSecGroupDaoImp(final ISecGroups secGroupDaoImp) {
        this.secGroupDaoImp = secGroupDaoImp;
    }

    /**
     * @return the projectDaoImp
     */
    public IProject getProjectDaoImp() {
        return projectDaoImp;
    }

    /**
     * @param projectDaoImp the projectDaoImp to set
     */
    public void setProjectDaoImp(final IProject projectDaoImp) {
        this.projectDaoImp = projectDaoImp;
    }

    /**
     * @return the surveyDaoImp
     */
    public ISurvey getSurveyDaoImp() {
        return surveyDaoImp;
    }

    /**
     * @param surveyDaoImp the surveyDaoImp to set
     */
    public void setSurveyDaoImp(final ISurvey surveyDaoImp) {
        this.surveyDaoImp = surveyDaoImp;
    }

    /**
     * @return the questionDaoImp
     */
    public IQuestionDao getQuestionDaoImp() {
        return questionDaoImp;
    }

    /**
     * @param questionDaoImp the questionDaoImp to set
     */
    public void setQuestionDaoImp(final IQuestionDao questionDaoImp) {
        this.questionDaoImp = questionDaoImp;
    }


    /**
     * @return the surveyformatDaoImp
     */
    public ISurveyFormatDao getSurveyformatDaoImp() {
        return surveyformatDaoImp;
    }

    /**
     * @param surveyformatDaoImp the surveyformatDaoImp to set
     */
    public void setSurveyformatDaoImp(ISurveyFormatDao surveyformatDaoImp) {
        this.surveyformatDaoImp = surveyformatDaoImp;
    }

    /**
     * @return the catLocationTypeDao
     */
    public ICatLocationTypeDao getCatLocationTypeDao() {
        return catLocationTypeDao;
    }

    /**
     * @param catLocationTypeDao the catLocationTypeDao to set
     */
    public void setCatLocationTypeDao(ICatLocationTypeDao catLocationTypeDao) {
        this.catLocationTypeDao = catLocationTypeDao;
    }



    /**
     * @return catLocationDao
     */
    public ICatLocation getCatLocationDao() {
        return catLocationDao;
    }

    /**
     * @param catLocationDao catLocationDao
     */
    public void setCatLocationDao(ICatLocation catLocationDao) {
        this.catLocationDao = catLocationDao;
    }

    /**
     * @return {@link CatLocation}
     */
    public ICatLocation getCatLocation() {
        return catLocationDao;
    }

    /**
     * @param catLocation {@link CatLocation}
     */
    public void setCatLocation(final ICatLocation catLocation) {
        this.catLocationDao = catLocation;
    }

    /**
     * @return {@link Poll}
     */
    public IPoll getiPoll() {
        return iPoll;
    }

    /**
     * @param poll the iPoll to set
     */
    public void setiPoll(final IPoll poll) {
        this.iPoll = poll;
    }

    /**
     * Helper to create poll
     * @return poll
     **/
    public Poll createPoll(){
        final Poll poll = new Poll();
        poll.setCreatedAt(new Date());
        poll.setQuestion(createQuestion("Do you eat pizza", "yesNo"));
        poll.setPollHash("HASH");
        poll.setPollOwner(createUser());
        poll.setPollCompleted(true);
        getiPoll().saveOrUpdate(poll);
        return poll;

    }

     /**
     * Helper to create Poll Result.
     * @param questionAnswer {@link QuestionsAnswers}
     * @param poll {@link Poll}
     * @return state
     */
    public PollResult createPollResults(final QuestionsAnswers questionAnswer, final Poll poll){
        final PollResult pollRes = new PollResult();
        pollRes.setAnswer(questionAnswer);
        pollRes.setIpaddress("127.0.0.1");
        pollRes.setPoll(poll);
        pollRes.setVotationDate(new Date());
        getiPoll().saveOrUpdate(pollRes);
        return pollRes;

    }

    /**
     * Helper to create state.
     * @param name name of state
     * @return state
     */
    public CatState createState(final String name){
        final CatState state = new CatState();
        state.setDescState(name);
        state.setStateImage("image.jpg");
        getCatStateDaoImp().saveOrUpdate(state);
        return state;
    }

    /**
     * Create project.
     * @param name Project's name
     * @param descProject Project Description
     * @param infoProject Informations's Project
     * @param state Project's state
     * @param user user
     * @return {@link Project}
     */
    public Project createProject(
            final String name,
            final String descProject,
            final String infoProject,
            final CatState state,
            final SecUsers user) {
          Project project = new Project();
          project.setStateProject(state);
          project.setProjectDateFinish(new Date());
          project.setProjectDateStart(new Date());
          project.setProjectInfo(infoProject);
          project.setProjectDescription(descProject);
          project.setUsers(user);
          getProjectDaoImp().saveOrUpdate(project);
          return project;
    }

    /**
     * Create {@link Client}.
     * @param name name
     * @param project {@link Project}
     * @return {@link Client}
     */
    public Client createClient(final String name, final Project project){
        final Client client = new Client();
        client.setClientName(name);
        client.setProject(project);
        client.setClientEmail("");
        client.setClientDescription("");
        client.setClientFax("");
        client.setClientTelephone("");
        client.setClientTwitter("");
        client.setClientUrl("");
        getClientDao().saveOrUpdate(client);
        return client;
    }


    /**
     * Helper to create Secondary User.
     * @param name user name
     * @param secUser {@link SecUsers}
     * @return state
     */
    public SecUserSecondary createSecondaryUser(
            final String name,
            final SecUsers secUser){
        final SecUserSecondary user= new SecUserSecondary();
        user.setCompleteName(name);
        user.setUsername(name);
        user.setPassword("12345");
        user.setUserEmail(name+"@users.com");
        user.setEnjoyDate(new Date());
        user.setInviteCode("xxxxxxx");
        user.setOwner(true);
        user.setPublisher(true);
        user.setSecUser(secUser);
        user.setUserStatus(true);
        getSecUserDao().saveOrUpdate(user);
        return user;
    }

    /**
     * Create User.
     * @return {@link SecUsers}
     */
    public SecUsers createUser(){
        SecUsers user = new SecUsers();
        user.setTwitterAccount("testTWitterAccount");
        user.setTwitterPassword("testTwitterPwsd");
        getSecUserDao().saveOrUpdate(user);
        return user;
    }
    /**
     * Create User.
     * @param twitterAccount account
     * @param twitterPassword password
     * @return {@link SecUsers}
     */
    public SecUsers createUser(final String twitterAccount, final String twitterPassword){
        SecUsers user = new SecUsers();
        user.setTwitterAccount(twitterAccount);
        user.setTwitterPassword(twitterPassword);
        getSecUserDao().saveOrUpdate(user);
        return user;
    }

    /**
     * Helper to create LocationType.
     * @param locationTypeName locationTypeName
     * @return locationType
     */

    public CatLocationType createCatLocationType(final String locationTypeName){
        final CatLocationType catLocatType = new CatLocationType();
        catLocatType.setLocationTypeDescription(locationTypeName);
        catLocatType.setLocationTypeLevel(1);
        getCatLocationTypeDao().saveOrUpdate(catLocatType);
        return catLocatType;
    }


    /** Helper to create CatLocation.
     * @param locDescription locDescription
     * @param locTypeName locTypeName
     * @param Level Level
     * @return location
     */
    public CatLocation createCatLocation(final String locDescription, final String locTypeName, Integer Level){
        final CatLocation location = new CatLocation();
        location.setLocationActive("S");
        location.setlocationDescription(locDescription);
        location.setLocationLatitude(2F);
        location.setLocationLevel(Level);
        location.setLocationLongitude(3F);
        location.setTidtype(createCatLocationType(locTypeName));
        getCatLocationDao().saveOrUpdate(location);
      return location;

    }

    /**
     * Helper to create Group.
     * @param groupname user name
     * @return state
     */
    public SecGroups createGroups(final String groupname){
        final SecGroups group = new SecGroups();
        group.setGroupName(groupname);
        group.setIdState(1L);
        group.setGroupDescriptionInfo("Primer Grupo");
        getSecGroup().saveOrUpdate(group);
        return group;
    }

    /**
     * Helper to create Permission.
     * @param permissionName name
     * @return Permission
     */
    public SecPermission createPermission(final String permissionName){
        final SecPermission permission = new SecPermission();
        permission.setPermissionDescription(permissionName);
        permission.setPermission(permissionName);
        getSecPermissionDaoImp().saveOrUpdate(permission);
        return permission;
    }

    /**
     * Helper to add permission to user.
     * @param user user
     * @param permission permission
     */
    public void addPermissionToUser(final SecUsers user, final SecPermission permission){
       // final SecUserPermission userPerId = new SecUserPermission();
       // final SecUserPermissionId id = new SecUserPermissionId();
       /// id.setIdPermission(permission.getIdPermission());
       // id.setUid(user.getUid());
       // userPerId.setId(id);
        //userPerId.setState(true);
       // getSecUserDao().saveOrUpdate(userPerId);
    }

    /**
     * Helper to add user to group.
     * @param user user
     * @param group group
     */
    public void addGroupUser(
            final SecUserSecondary user,
            final SecGroups group)
    {
       /* final SecGroupUserId id = new SecGroupUserId();
        id.setGroupId(group.getGroupId());
        id.setUid(user.getUid());
        final SecGroupUser secGroupUser = new SecGroupUser();
        secGroupUser.setSecGroupUserId(id);
         secGroupUser.setSecUsers(user);
        secGroupUser.setSecGroups(group);*/
       // getSecUserDao().assingGroupToUser(secGroupUser);
    }

    /**
     * Helper permission to group.
     * @param permission permission
     * @param group group
     */
    public void addPermissionToGroup(
            final SecPermission permission,
            final SecGroups group)
    {
      //  final SecGroupPermissionId groupPermissionId = new SecGroupPermissionId();
       //// groupPermissionId.setGroupId(group.getGroupId());
     //   groupPermissionId.setIdPermission(permission.getIdPermission());
       // final SecGroupPermission groupPermission = new SecGroupPermission();
       // groupPermission.setId(groupPermissionId);
       // groupPermission.setSecGroups(group);
       // groupPermission.setSecPermission(permission);
       // getSecGroup().saveOrUpdate(groupPermission);
    }

    /**
     * Create question.
     * @param question question
     * @param patron patron
     * @return {@link Questions}
     */
    public Questions createQuestion(final String question, String patron){
        final Questions questions = new Questions();
        questions.setCatState(this.createState("active"));
        questions.setQidKey("1");
        questions.setQuestion(question);
        questions.setQuestionPattern(createQuestionPattern(patron));
        questions.setSecUsersQuestion(createUser());
        getQuestionDaoImp().saveOrUpdate(questions);
        return questions;
    }

    /**
     * Create question.
     * @param question question
     * @param patron patron
     * @param user user
     * @return {@link Questions}
     */
    public Questions createQuestion(final String question, final String patron, final SecUsers user){
        final Questions questions = new Questions();
        questions.setCatState(this.createState("active"));
        questions.setQidKey("1");
        questions.setSecUsersQuestion(user);
        questions.setQuestion(question);
        questions.setQuestionPattern(createQuestionPattern(patron));
        getQuestionDaoImp().saveOrUpdate(questions);
        return questions;
    }

    /**
     * Create Question Answer.
     * @param answer answer
     * @param question question
     * @param hash hash
     * @return {@link QuestionsAnswers}
     */
    public QuestionsAnswers createQuestionAnswer(final String answer, final Questions question, final String hash){
        final QuestionsAnswers questionsAnswers = new QuestionsAnswers();
        questionsAnswers.setAnswer(answer);
        questionsAnswers.setQuestions(question);
        questionsAnswers.setUniqueAnserHash(hash);
        getQuestionDaoImp().saveOrUpdate(questionsAnswers);
        System.out.println("Q "+questionsAnswers.getQuestionAnswerId());
        return questionsAnswers;
    }

    /**
     * Create Patron Domain.
     * @param typePatron name of patron
     * @return {@link QuestionPattern}
     */
    public QuestionPattern createQuestionPattern(final String typePatron){
        final QuestionPattern patron = new QuestionPattern();
        patron.setClass_("class.patron1.class");
        patron.setDesQid("patron Html");
        patron.setPatternTemplate("1");
        patron.setLabelQid("1");
        patron.setPatternType(typePatron);
        patron.setLevel(1);
        patron.setFinallity("save");
        //TODO: need patron dao to save this domain.
        getQuestionDaoImp().saveOrUpdate(patron);
        return patron;
    }

    /**
     *Helper to Create Survey Group.
     * @param surveyGroupName surveyGroupName
     * @return {@link SurveyGroup}
     *
     **/
    public SurveyGroup createSurveyGroup(String surveyGroupName){
        final SurveyGroup surveyGroup = new SurveyGroup();
        surveyGroup.setCatState(createState("editor"));
        surveyGroup.setDateCreate(new Date());
        surveyGroup.setGroupName(surveyGroupName);
        getSurveyDaoImp().saveOrUpdate(surveyGroup);
        return surveyGroup;

    }

    /**
     *Helper to Create Question Collection.
     * @param desCollection Collection Description
     * @return {@link QuestionColettion}
     *
     **/
    public QuestionColettion createQuestionCollect(String desCollection){
        final QuestionColettion qCollection = new QuestionColettion();
        qCollection.setCreationDate(new Date());
        qCollection.setDesColeccion(desCollection);
        qCollection.setSecUsers(createUser());
        getQuestionDaoImp().saveOrUpdate(qCollection);
        return qCollection;
    }
    /**
     * Helper to Create Surveys Format.
     * @return {@link SurveyFormat}
     * */
    public SurveyFormat createSurveyFormat(){
        final SurveyFormat sformat = new SurveyFormat();
        sformat.setDateCreated(new Date());
        sformat.setSurveyFormatName("Schools");
        sformat.getSurveyGroups().add(createSurveyGroup("editors"));
        getSurveyformatDaoImp().saveOrUpdate(sformat);
        return sformat;
    }


    /**
     * Create TWeetPoll.
     * @param tweetId tweetId
     * @param closeNotification tweetId
     * @param resultNotification resultNotification
     * @param allowLiveResults allowLiveResults
     * @param publishTweetPoll publishTweetPoll
     * @param scheduleTweetPoll publishTweetPoll
     * @param scheduleDate scheduleDate
     * @param publicationDateTweet publicationDateTweet
     * @param completed completed
     * @param tweetOwner tweetOwner
     * @param question question
     * @return tweetPoll.
     */
    public TweetPoll createTweetPoll(
             Long tweetId,
             Boolean closeNotification,
             Boolean resultNotification,
             Boolean allowLiveResults,
             Boolean publishTweetPoll,
             Boolean scheduleTweetPoll,
             Date scheduleDate,
             Date publicationDateTweet,
             Boolean completed,
             SecUsers tweetOwner,
             Questions question){
        final TweetPoll tweetPoll = new TweetPoll();
        tweetPoll.setCloseNotification(closeNotification);
        tweetPoll.setResultNotification(resultNotification);
        tweetPoll.setAllowLiveResults(allowLiveResults);
        tweetPoll.setCompleted(completed);
        tweetPoll.setPublicationDateTweet(publicationDateTweet);
        tweetPoll.setPublishTweetPoll(publishTweetPoll);
        tweetPoll.setQuestion(question);
        tweetPoll.setScheduleDate(scheduleDate);
        tweetPoll.setScheduleTweetPoll(scheduleTweetPoll);
        tweetPoll.setTweetId(tweetId);
        tweetPoll.setTweetOwner(tweetOwner);
        getTweetPoll().saveOrUpdate(tweetPoll);
        return tweetPoll;
    }

    /**
     * Create Published {@link TweetPoll}.
     * @param tweetOwner tweet owner
     * @param question question
     * @return {@link TweetPoll}
     */
    public TweetPoll createPublishedTweetPoll(final SecUsers tweetOwner, final Questions question){
       return createTweetPoll(12345L, false, false, false, true, false, new Date(), new Date(), false, tweetOwner, question);
    }

    /**
     * Create Not Published {@link TweetPoll}.
     * @param tweetOwner tweet owner
     * @param question question
     * @return {@link TweetPoll}
     */
    public TweetPoll createNotPublishedTweetPoll(final SecUsers tweetOwner, final Questions question){
       return createTweetPoll(null, false, false, false, false, false, new Date(), null, false, tweetOwner, question);
    }

    /**
     * Create {@link TweetPollSwitch}.
     * @param questionsAnswers  {@link QuestionsAnswers}.
     * @param tweetPollDomain {@link TweetPoll}.
     * @return {@link TweetPollSwitch}.
     */
    public TweetPollSwitch createTweetPollSwitch(final QuestionsAnswers questionsAnswers, final TweetPoll tweetPollDomain){
        final TweetPollSwitch tPollSwitch = new TweetPollSwitch();
        tPollSwitch.setAnswers(questionsAnswers);
        tPollSwitch.setTweetPoll(tweetPollDomain);
        tPollSwitch.setCodeTweet(questionsAnswers.getUniqueAnserHash());
        getTweetPoll().saveOrUpdate(tPollSwitch);
        return tPollSwitch;
    }

    /**
     * Create TweetPoll Result
     * @param tweetPollSwitch {@link TweetPollResult}
     * @param Ip ip address
     * @return {@link TweetPollResult}.
     */
    public TweetPollResult createTweetPollResult(final TweetPollSwitch tweetPollSwitch, final String Ip){
        final TweetPollResult tweetPollResult = new TweetPollResult();
        tweetPollResult.setIpVote(Ip);
        tweetPollResult.setTweetPollSwitch(tweetPollSwitch);
        tweetPollResult.setTweetResponseDate(new Date());
        getTweetPoll().saveOrUpdate(tweetPollResult);
        return tweetPollResult;
    }

    /**
     * Create Fast TweetPoll Votes.
     * @return tweet poll
     */
    public TweetPoll createFastTweetPollVotes(){
        final SecUserSecondary secondary = createSecondaryUser("jhon", createUser());
        final Questions question = createQuestion("who I am?", "");
        final QuestionsAnswers questionsAnswers1 = createQuestionAnswer("yes", question, "12345");
        final QuestionsAnswers questionsAnswers2 = createQuestionAnswer("no", question, "12346");
        final TweetPoll tweetPoll = createPublishedTweetPoll(secondary.getSecUser(), question);
        final TweetPollSwitch pollSwitch1 = createTweetPollSwitch(questionsAnswers1, tweetPoll);
        final TweetPollSwitch pollSwitch2 = createTweetPollSwitch(questionsAnswers2, tweetPoll);
        createTweetPollResult(pollSwitch1, "192.168.0.1");
        createTweetPollResult(pollSwitch1, "192.168.0.2");
        createTweetPollResult(pollSwitch2, "192.168.0.3");
        createTweetPollResult(pollSwitch2, "192.168.0.4");
        System.out.println("tw "+tweetPoll);
        return tweetPoll;
    }

    /**
     * @return the activateNotifications
     */
    public Boolean getActivateNotifications() {
        return activateNotifications;
    }

    /**
     * @param activateNotifications the activateNotifications to set
     */
    public void setActivateNotifications(Boolean activateNotifications) {
        this.activateNotifications = activateNotifications;
    }

    /**
     * @return the clientDao
     */
    public IClientDao getClientDao() {
        return clientDao;
    }

    /**
     * @param clientDao the clientDao to set
     */
    public void setClientDao(final IClientDao clientDao) {
        this.clientDao = clientDao;
    }

    /**
     * @return the iTweetPoll
     */
    public ITweetPoll getTweetPoll() {
        return iTweetPoll;
    }

    /**
     * @param iTweetPoll the iTweetPoll to set
     */
    public void setTweetPoll(final ITweetPoll iTweetPoll) {
        this.iTweetPoll = iTweetPoll;
    }
}
