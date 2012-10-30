#coding: latin-1
import requests
from os import system
import json

def pesquisa(nome):
        if nome == '':
                r = requests.get('http://127.0.0.1/usuarios/all.json')
                geral = []
                if 200 == r.status_code:
                        s = r.content
                        geral = json.loads(s)
                        i = 0
                        
                        while i < len(geral):
                                print 'Nome: ', geral[i]['nome']
                                print 'ID: ', geral[i]['id']
                                print '\n'
                                i += 1
                else:
                        print 'Nenhuma informação encontrada.'
        else:
                r = requests.get('http://127.0.0.1/usuarios/' + nome + '.json')
                if 200 == r.status_code:
                        s = r.content
                        user = json.loads(s)
                        print 'Nome: ', user['nome']
                        print 'ID: ', user['id']
                else:
                        print 'Usuário inexistente'

system('cls')

nome = raw_input('Forneça o nome do usuário ou [Enter] para exibir todos os usuários: ')
pesquisa(nome)
