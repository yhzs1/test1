import greenfoot.*;

/**
 * Write a description of class StartInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartInterface extends GameMenu
{
    /**
     * Constructor for objects of class StartInterface.
     * 
     */
    public StartInterface()
    {
        prepare();
        start();
    }

    /**
     * 开始前先为你的剧本创建场景
     * 添加元件到你的场景
     */
    private void prepare()
    {
        NatureTileset naturetileset = new NatureTileset();
        addObject(naturetileset, 380, 447);
        naturetileset.setLocation(387, 447);
        Title title = new Title();
        addObject(title, 411, 138);
        DockSpawn dockspawn = new DockSpawn();
        addObject(dockspawn, 414, 379);
        naturetileset.setLocation(404, 447);
        dockspawn.setLocation(396, 378);
        naturetileset.setLocation(391, 447);
        Introducation introducation = new Introducation();
        addObject(introducation, 81, 379);
        Start start = new Start();
        addObject(start, 382, 537);
        start.setLocation(391, 537);
        author author = new author();
        addObject(author, 687, 391);
        author.setLocation(691, 369);
        introducation.setLocation(83, 369);
        start.setLocation(398, 537);
        introducation.setLocation(130, 365);
        title.setLocation(406, 133);
        naturetileset.setLocation(391, 454);
        dockspawn.setLocation(392, 384);
        title.setLocation(410, 163);
        introducation.setLocation(134, 364);
        author.setLocation(685, 367);
        start.setLocation(402, 525);
        start.setLocation(411, 538);
        author.setLocation(777, 334);
        naturetileset.setLocation(463, 465);
        start.setLocation(454, 550);
        title.setLocation(492, 153);
        dockspawn.setLocation(456, 393);
        start.setLocation(479, 559);
        naturetileset.setLocation(483, 471);
        author.setLocation(862, 350);
        title.setLocation(481, 148);
        naturetileset.setLocation(458, 475);
        title.setLocation(491, 144);
        dockspawn.setLocation(479, 407);
        naturetileset.setLocation(476, 476);
        naturetileset.setLocation(491, 493);
        dockspawn.setLocation(489, 424);
        naturetileset.setLocation(485, 493);
        dockspawn.setLocation(483, 424);
        start.setLocation(495, 562);
        introducation.setLocation(104, 367);
        author.setLocation(889, 351);
        start.setLocation(507, 570);
        dockspawn.setLocation(488, 392);
        naturetileset.setLocation(479, 474);
        dockspawn.setLocation(507, 398);
        naturetileset.setLocation(492, 474);
        dockspawn.setLocation(514, 406);
        naturetileset.setLocation(495, 475);
        dockspawn.setLocation(482, 389);
        naturetileset.setLocation(486, 470);
        naturetileset.setLocation(484, 467);
        dockspawn.setLocation(484, 398);
        introducation.setLocation(98, 386);
        author.setLocation(884, 387);
        introducation.setLocation(105, 388);
        author.setLocation(873, 390);
    }
    
    public void start(){
        GameWorld.gw=1;
    }

}
