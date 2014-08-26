grammar ScratchCLike;

@lexer::header {
  package apu.antlr.clike;
}

@parser::header {
  package apu.antlr.clike;
}

eval : body;
body : (line | braces)*;
braces : emptyBraces | methodBody | ifElse | forLoop | whileLoop | repeatSingleFrameLoop | whenDef;
emptyBraces : OPENB body CLOSEB;
methodBody : METHOD_DEF_TAG (ATOMIC_METHOD_TAG)? IDENTIFIER OPENP 
	(paramsDef)? CLOSEP OPENB body CLOSEB;

line : (methodCall | variableSet | arrayCreate | returnStatement) SEMICOLON;

returnStatement : RETURN_TAG (varExp)?;

whenDef : WHEN_TAG 
	(WHEN_CLICKED | WHEN_RECEIVE | WHEN_KEY
	| WHEN_CLONED | WHEN_SENSOR | WHEN_FLAG) (varExp)* OPENB body CLOSEB;

ifElse : IF_TAG conditionAndOr OPENB body CLOSEB (ELSE_TAG OPENB body CLOSEB)?;
forLoop : FOR_TAG OPENP variableSet SEMICOLON conditionAndOrNoP SEMICOLON 
          variableSet CLOSEP OPENB body CLOSEB;
whileLoop : WHILE_TAG (conditionAndOr | (OPENP BOOL_TRUE CLOSEP)) OPENB body CLOSEB;
repeatSingleFrameLoop : REPEAT_TAG SINGLE_FRAME_TAG OPENP NUMBER CLOSEP OPENB body CLOSEB;

conditionItem : BOOL_NOT? (condition | conditionAndOr);
conditionAndOr : OPENP (conditionItem (BOOL_AND | BOOL_OR))? conditionItem 
          CLOSEP;
conditionAndOrNoP : (conditionItem (BOOL_AND | BOOL_OR))? conditionItem;
condition : (varExp 
            ((BOOL_EQUALS | BOOL_NEQUALS) | (BOOL_GT | BOOL_LT) | (BOOL_GTE | BOOL_LTE)) 
            varExp) | methodCall;

methodCall : IDENTIFIER OPENP params? CLOSEP;
variableSet : ((IDENTIFIER | arrayIdentifier) (EQUALS | PLUS_EQUALS | MINUS_EQUALS)
    varExp) | ((IDENTIFIER | arrayIdentifier) (PLUS_PLUS | MINUS_MINUS));
varExp : ((NUMBER | STRINGLITERAL | IDENTIFIER) | (arrayIdentifier | mathExp));
arrayCreate : arrayDef EQUALS (SINGLE_FRAME_TAG)? ARRAY_TAG OPENC NUMBER CLOSEC;
arrayDef : IDENTIFIER OPENC CLOSEC;
paramsDef : (paramDef COMMA)* paramDef;
paramDef : IDENTIFIER | arrayDef;
params : ((varExp COMMA)* varExp) | arrayDef;

mathExp : mathAdditionExp;
mathAdditionExp
    :    mathMultiplyExp 
         ( MATH_PLUS mathMultiplyExp 
         | MATH_MINUS mathMultiplyExp
         )* 
    ;

mathMultiplyExp
    :    mathAtomExp
         ( MATH_TIMES mathAtomExp 
         | MATH_DIVIDE mathAtomExp
         | MATH_MODULO mathAtomExp
         )* 
    ;

mathAtomExp
    :    (NUMBER | IDENTIFIER | (arrayIdentifier | methodCall))
    |    OPENP mathAdditionExp CLOSEP
    ;

arrayIdentifier : IDENTIFIER OPENC varExp CLOSEC;

BOOL_TRUE : 'true';

IF_TAG : 'if';
ELSE_TAG : 'else';
BOOL_AND : '&&';
BOOL_OR : '||';
BOOL_NOT : '!';
BOOL_EQUALS : '==';
BOOL_NEQUALS : '!=';
BOOL_GT : '>';
BOOL_LT : '<';
BOOL_GTE : '>=';
BOOL_LTE : '<=';

MATH_PLUS : '+';
MATH_MINUS : '-';
MATH_TIMES : '*';
MATH_DIVIDE : '/';
MATH_MODULO : '%';

FOR_TAG : 'for';
WHILE_TAG : 'while';

METHOD_DEF_TAG : 'def';
ATOMIC_METHOD_TAG : '@atomic';

RETURN_TAG : 'return';

WHEN_TAG : '@when';
WHEN_CLICKED : 'clicked';
WHEN_RECEIVE : 'received';
WHEN_KEY : 'keyPressed';
WHEN_CLONED : 'cloned';
WHEN_SENSOR : 'sensorGreaterThan';
WHEN_FLAG : 'greenFlag';

REPEAT_TAG : 'repeat';
SINGLE_FRAME_TAG : '@singleframe';

ARRAY_TAG : 'array';
IDENTIFIER : (LETTER)(LETTER | NUMBER)* ;

STRINGLITERAL : '"' (AChar)* '"';
fragment AChar : ~["\\\r\n]
    |   AEscapeSequence ;
fragment AEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

OPENP : '(';
CLOSEP : ')';
OPENB : '{';
CLOSEB : '}';
SEMICOLON : ';';
EQUALS : '=';
PLUS_EQUALS : '+=';
MINUS_EQUALS : '-=';
PLUS_PLUS : '++';
MINUS_MINUS : '--';
COMMA : ',';
OPENC : '[';
CLOSEC : ']';
NUMBER
    :    ('0'..'9')+ ('.' ('0'..'9')+)?
    ;
LETTER : [a-zA-Z_];
WS  
    :   (' ' | '\t' | '\r'| '\n') -> skip
    ;
BlockComment
    :   '/*' .*? '*/'
        -> channel(HIDDEN)
    ;

LineComment
    :   '//' ~[\r\n]*
        -> channel(HIDDEN)
    ;