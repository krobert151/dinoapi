insert into person (id, username, password, name, last_name, email, phone_number, account_non_expired, account_non_locked, credentials_non_expired, enabled, last_password_change_at , password_expirate_at ) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a6', 'rducker0', '{bcrypt}$2a$10$fHQTADM5GIlB1kIOR7iabON8te6lbUuH/6jlyjTo1zE/vHGJ14LrK', 'Rikki', 'Ducker', 'rducker0@epa.gov', '451-536-9651', true, true, true, true, '2023-12-17 17:22:00', '2023-12-17 17:24:00');
insert into admin (id, puesto) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a6','administrator');
insert into person_roles (roles, person_id) values (0 ,'80d768ef-831a-4cfe-94e6-fda1eb4452a6');

insert into classification (id, type, schema_order, name, description, classification_id) values ('a4f3c33b-e997-45e3-a983-54ec493c79e7', 0,0, 'Animalia', 'Animals are multicellular, eukaryotic organisms in the biological kingdom Animalia. With few exceptions, animals consume organic material, breathe oxygen, have myocytes and are able to move, can reproduce sexually, and grow from a hollow sphere of cells, the blastula, during embryonic development',  null );
insert into classification (id, type, schema_order, name, description, classification_id) values ('1b7fd75a-14c5-48aa-a0ee-ba652ea2c79f', 0,1, 'Eumetazoa', 'A widely accepted hypothesis, based on molecular data (mostly 18S rRNA sequences), divides Bilateria into four superphyla: Deuterostomia, Ecdysozoa, Lophotrochozoa, and Platyzoa (sometimes included in Lophotrochozoa). The last three groups are also collectively known as Protostomia.',  'a4f3c33b-e997-45e3-a983-54ec493c79e7' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('b836a40d-2b7a-4ed5-a986-c8c918bd5ae3', 0,2, 'Bilateria', 'Bilateria (/ˌbaɪləˈtɪəriə/) is a large clade/infrakingdom of animals called bilaterians, characterized by bilateral symmetry (i.e. having a left and a right side that are mirror images of each other) during embryonic development. This means their body plans are laid around a longitudinal axis (rostral–caudal axis) with a front (or "head") and a rear (or "tail") end, as well as a left–right–symmetrical belly (ventral) and back (dorsal) surface.[2] Nearly all bilaterians maintain a bilaterally symmetrical body as adults; the most notable exception is the echinoderms, which achieve secondary pentaradial symmetry as adults, but are bilaterally symmetrical as an embryo. Cephalization is also a characteristic feature among most bilaterians, where the special sense organs and central nerve ganglia become concentrated at the front/rostral end.',  '1b7fd75a-14c5-48aa-a0ee-ba652ea2c79f' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('e283d77d-b9da-4a18-bea2-b37581f5be61', 0,3, 'Deuterostome', 'Deuterostomes (from Greek: lit.  second mouth) are bilaterian animals of the superphylum Deuterostomia (/ˌdjuːtərəˈstoʊmi.ə/),[2][3] typically characterized by their anus forming before the mouth during embryonic development. The three major clades of extant deuterostomes include chordates (vertebrates, lancelets, sea squirts, salps and larvaceans), echinoderms (sea stars, brittle stars, sea urchins, sea cucumbers and sea lilies) and hemichordates (acorn worms).',  'b836a40d-2b7a-4ed5-a986-c8c918bd5ae3' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('5906673c-88c4-4a2b-9f15-dc79d736405a', 1,0, 'Chordate', 'A chordate (/ˈkɔːrdeɪt/ KOR-dayt) is a deuterostomic animal belonging to the phylum Chordata (/kɔːrˈdeɪtə/ kor-DAY-tə). All chordates possess, at some point during their larval or adult stages, five distinctive physical characteristics (synapomorphies) that distinguish them from other taxa. These five synapomorphies are a notochord, a hollow dorsal nerve cord, an endostyle or thyroid, pharyngeal slits, and a post-anal tail. The name "chordate" comes from the first of these synapomorphies, the notochord, which plays a significant role in chordate body plan structuring and movements. Chordates are also bilaterally symmetric, have a coelom, possess a closed circulatory system, and exhibit metameric segmentation.',  'e283d77d-b9da-4a18-bea2-b37581f5be61' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('169dc815-3779-4a02-a0f5-84867e184095', 1,1, 'Vertebrate', 'Vertebrates (/ˈvɜːrtəbrɪts, -ˌbreɪts/)[3] are deuterostomal animals with bony or cartilaginous axial endoskeleton — known as the vertebral column, spine or backbone — around and along the spinal cord, including all fish, amphibians, reptiles, birds and mammals. The vertebrates consist of all the taxa within the subphylum Vertebrata (/ˌvɜːrtəˈbreɪtə/)[4] (chordates with backbones) and represent the overwhelming majority of the phylum Chordata, with currently about 69,963 species described.', '5906673c-88c4-4a2b-9f15-dc79d736405a');
insert into classification (id, type, schema_order, name, description, classification_id) values ('d9579b33-01c1-4899-b3b8-8a0614e9de69', 1,2, 'Gnathostomata', 'Gnathostomata (/ˌnæθoʊˈstɒmətə/; from Greek: γνάθος (gnathos) "jaw" + στόμα (stoma) "mouth") are the jawed vertebrates. Gnathostome diversity comprises roughly 60,000 species, which accounts for 99% of all living vertebrates, including humans. In addition to opposing jaws, living gnathostomes have true teeth (a characteristic which has subsequently been lost in some), paired appendages (pectoral and pelvic fins, arms, legs, wings, etc.),[2] the elastomeric protein of elastin,[3] and a horizontal semicircular canal of the inner ear, along with physiological and cellular anatomical characters such as the myelin sheaths of neurons, and an adaptive immune system that has the discrete lymphoid organs of spleen and thymus,[4] and uses V(D)J recombination to create antigen recognition sites, rather than using genetic recombination in the variable lymphocyte receptor gene.',  '169dc815-3779-4a02-a0f5-84867e184095' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('7ab33911-7250-441e-9080-0c414c94d8c6', 1,3, 'Tetrapod', 'A tetrapod (/ˈtɛtrəˌpɒd/;[5] from Ancient Greek τετρα- (tetra-) four, and πούς (poús) foot) is any four-limbed vertebrate animal of the superclass Tetrapoda (/tɛˈtræpədə/).[6] Tetrapods include all extant and extinct amphibians and amniotes, with the latter in turn evolving into two major clades, the sauropsids (reptiles, including dinosaurs and therefore birds) and synapsids (extinct pelycosaurs, therapsids and all extant mammals). Some tetrapods such as snakes, legless lizards, and caecilians had evolved to become limbless via mutations of the Hox gene,[7] although some do still have a pair of vestigial spurs that are remnants of the hindlimbs.', 'd9579b33-01c1-4899-b3b8-8a0614e9de69' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('f691bb49-177c-4974-adcb-14581b2ba5e1', 2,0, 'Sauropsida', 'Sauropsida (Greek for "lizard faces") is a clade of amniotes, broadly equivalent to the class Reptilia, though typically used in a broader sense to include both extinct stem-group relatives of modern reptiles, as well as birds (which, as theropod dinosaurs, are nested within reptiles as more closely related to crocodilians than to lizards or turtles).[1] The most popular definition states that Sauropsida is the sister taxon to Synapsida, the other clade of amniotes which includes mammals as its only modern representatives. Although early synapsids have historically been referred to as "mammal-like reptiles", all synapsids are more closely related to mammals than to any modern reptile. Sauropsids, on the other hand, include all amniotes more closely related to modern reptiles than to mammals. This includes Aves (birds), which are now recognized as a subgroup of archosaurian reptiles despite originally being named as a separate class in Linnaean taxonomy.',  '7ab33911-7250-441e-9080-0c414c94d8c6' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('b293f3e3-eb1d-4701-855f-9097a7cb8bdd', 2,1, 'Diapsid', 'Diapsids ("two arches") are a clade of sauropsids, distinguished from more primitive eureptiles by the presence of two holes, known as temporal fenestrae, in each side of their skulls. The group first appeared about three hundred million years ago during the late Carboniferous period.[1] All diapsids other than the most primitive ones in the clade Araeoscelidia are sometimes placed into the clade Neodiapsida. The diapsids are extremely diverse, and include birds and all modern reptile groups, including turtles, which were historically thought to lie outside the group.[2] Although some diapsids have lost either one hole (lizards), or both holes (snakes and turtles), or have a heavily restructured skull (modern birds), they are still classified as diapsids based on their ancestry. At least 17,084 species of diapsid animals are extant: 9,159 birds,[3] and 7,925 snakes, lizards, tuatara, turtles, and crocodiles.',  'f691bb49-177c-4974-adcb-14581b2ba5e1' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('34b2bcfd-c418-40ae-8dbe-2fb97f2b1977', 2,2, 'Dinosaur', 'Dinosaurs are a diverse group of reptiles[note 1] of the clade Dinosauria. They first appeared during the Triassic period, between 243 and 233.23 million years ago (mya), although the exact origin and timing of the evolution of dinosaurs is a subject of active research. They became the dominant terrestrial vertebrates after the Triassic–Jurassic extinction event 201.3 mya and their dominance continued throughout the Jurassic and Cretaceous periods. The fossil record shows that birds are feathered dinosaurs, having evolved from earlier theropods during the Late Jurassic epoch, and are the only dinosaur lineage known to have survived the Cretaceous–Paleogene extinction event approximately 66 mya. Dinosaurs can therefore be divided into avian dinosaurs—birds—and the extinct non-avian dinosaurs, which are all dinosaurs other than birds.',  'b293f3e3-eb1d-4701-855f-9097a7cb8bdd' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('e25d584b-af0d-4c5d-8e72-22a6e8dcd49a', 3,0, 'Saurischia', 'Saurischia (/sɔːˈrɪskiə/ saw-RIS-kee-ə, meaning "reptile-hipped" from the Greek sauros (σαῦρος) meaning lizard and ischion (ἴσχιον) meaning hip joint)[1] is one of the two basic divisions of dinosaurs (the other being Ornithischia), classified by their hip structure. Saurischia and Ornithischia were originally called orders by Harry Seeley in 1888[2] though today most paleontologists classify Saurischia as an unranked clade rather than an order.[3]','34b2bcfd-c418-40ae-8dbe-2fb97f2b1977' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('23df328c-d250-48ea-a46d-694686084bd6', 3,1, 'Theropoda', 'Theropoda (/θɪəˈrɒpədə/;[2] from Ancient Greek θηρίον (thēríon) wild beast, and πούς, ποδός (poús, podós) foot), whose members are known as theropods, is a dinosaur clade that is characterized by hollow bones and three toes and claws on each limb. Theropods are generally classed as a group of saurischian dinosaurs. They were ancestrally carnivorous, although a number of theropod groups evolved to become herbivores and omnivores. Theropods first appeared during the Carnian age of the late Triassic period 231.4 million years ago (Ma)[3] and included the majority of large terrestrial carnivores from the Early Jurassic until at least the close of the Cretaceous, about 66 Ma. In the Jurassic, birds evolved from small specialized coelurosaurian theropods, and are today represented by about 10,500 living species.','e25d584b-af0d-4c5d-8e72-22a6e8dcd49a' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('370b4f7d-fedf-471f-afce-811c89616731', 3,2, 'Coelurosauria', 'Coelurosauria (/sɪˌljʊərəˈsɔːri.ə/;[6][7] from Greek, meaning "hollow-tailed lizards") is the clade containing all theropod dinosaurs more closely related to birds than to carnosaurs. Coelurosauria is a subgroup of theropod dinosaurs that includes compsognathids, tyrannosaurs, ornithomimosaurs, and maniraptorans; Maniraptora includes birds, the only known dinosaur group alive today.[8] Most feathered dinosaurs discovered so far have been coelurosaurs. Philip J. Currie had considered it likely and probable that all coelurosaurs were feathered.[9] However, several skin impressions found for some members of this group show pebbly, scaly skin, indicating that feathers did not completely replace scales in all taxa. In the past, Coelurosauria was used to refer to all small theropods, but this classification has since been amended.','23df328c-d250-48ea-a46d-694686084bd6' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('67d1ea99-3bdc-400c-8757-b33858beb58f', 3,3, 'Tyrannosauroidea', 'Tyrannosauroidea (meaning tyrant lizard forms) is a superfamily (or clade) of coelurosaurian theropod dinosaurs that includes the family Tyrannosauridae as well as more basal relatives. Tyrannosauroids lived on the Laurasian supercontinent beginning in the Jurassic Period. By the end of the Cretaceous Period, tyrannosauroids were the dominant large predators in the Northern Hemisphere, culminating in the gigantic Tyrannosaurus. Fossils of tyrannosauroids have been recovered on what are now the continents of North America, Europe and Asia, with fragmentary remains possibly attributable to tyrannosaurs also known from South America and Australia.','370b4f7d-fedf-471f-afce-811c89616731' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('e7a693d5-bc24-4f70-876b-1a7e423382c9', 4, 0,'Tyrannosauridae', 'Tyrannosauridae (or tyrannosaurids, meaning "tyrant lizards") is a family of coelurosaurian theropod dinosaurs that comprises two subfamilies containing up to thirteen genera, including the eponymous Tyrannosaurus. The exact number of genera is controversial, with some experts recognizing as few as three. All of these animals lived near the end of the Cretaceous Period and their fossils have been found only in North America and Asia.','67d1ea99-3bdc-400c-8757-b33858beb58f' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('cba20110-090e-42a8-a850-bc37d11d9df9', 4, 1,'Tyrannosauridae', 'Subfamily of Tyrannosauridae','e7a693d5-bc24-4f70-876b-1a7e423382c9' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('330767d5-60a5-42b4-9173-0ca9b1145873', 4, 2,'Tyrannosaurini', 'Tribe of Tyrannosauridae','cba20110-090e-42a8-a850-bc37d11d9df9' );
insert into classification (id, type, schema_order, name, description, classification_id) values ('d1638980-6a3e-47ba-8c68-ec059ca560f1', 5, 0,'Tyrannosaurus', 'Genius of T-rex','330767d5-60a5-42b4-9173-0ca9b1145873' );

insert into period (id, name, started, finished, description) values ( '4cb26b28-38c0-45e5-a4de-ce5a97931469','Late Cretaceous', 100.5, 65,'The Late Cretaceous (100.5–66 Ma) is the younger of two epochs into which the Cretaceous Period is divided in the geologic time scale. Rock strata from this epoch form the Upper Cretaceous Series. The Cretaceous is named after creta, the Latin word for the white limestone known as chalk. The chalk of northern France and the white cliffs of south-eastern England date from the Cretaceous Period.')

insert into dinosaur (id, scientific_name, name, height, length, live_since, live_until, num_theeth, weight, clasification_id) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a3', 'tiranosaurus-rex', 'tiranosaurus', 5, 12, 68, 66, 100, 6000, 'd1638980-6a3e-47ba-8c68-ec059ca560f1');

insert into dinosaur_periods (dinosaur_id, periods_id) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a3','4cb26b28-38c0-45e5-a4de-ce5a97931469');