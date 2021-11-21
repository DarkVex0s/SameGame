### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java

### REGLES ESSENTIELLES ###

Start.class : Start.java EcranJeu.class
	${JC} ${JCFLAGS} Start.java

EcranJeu.class : EcranJeu.java Action.class FondEcran.class
	${JC} ${JCFLAGS} EcranJeu.java

FondEcran.class : FondEcran.java
	${JC} ${JCFLAGS} FondEcran.java

Action.class : Action.java Lecture.class Grille.class
	${JC} ${JCFLAGS} Action.java

Grille.class : Grille.java Creation.class
	${JC} ${JCFLAGS} Grille.java

Creation.class : Creation.java ActionSouris.class
	${JC} ${JCFLAGS} Creation.java

ActionSouris.class : ActionSouris.java Groupement.class Fall.class FinJeu.class Decalage.class Score.class
	${JC} ${JCFLAGS} ActionSouris.java

Score.class : Score.java
	${JC} ${JCFLAGS} Score.java

Decalage.class : Decalage.java
	${JC} ${JCFLAGS} Decalage.java

FinJeu.class : FinJeu.java EndScreen.class
	${JC} ${JCFLAGS} FinJeu.java

EndScreen.class : EndScreen.java EndAction.class
	${JC} ${JCFLAGS} EndScreen.java

EndAction.class : EndAction.java
	${JC} ${JCFLAGS} EndAction.java

Fall.class : Fall.java
	${JC} ${JCFLAGS} Fall.java

Groupement.class : Groupement.java
	${JC} ${JCFLAGS} Groupement.java

Lecture.class : Lecture.java
	${JC} ${JCFLAGS} Lecture.java

### REGLES OPTIONNELLES ###

run : Start.class
	${JVM} Start

clean :
	-rm -f *.class

### FIN ###
