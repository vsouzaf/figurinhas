package br.com.vsouzaf.figurinhas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vsouzaf.figurinhas.config.MyUserDetails;
import br.com.vsouzaf.figurinhas.entity.Usuario;
import br.com.vsouzaf.figurinhas.repository.UsuarioRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuaŕio ou senha inválidos");
        }
        
        return new MyUserDetails(usuario);
        
    }
    
}
