import React from 'react';
import User from './User';
import Message from './Message';

const Card = (props) => {
    return (
        <div className='card'>
        <User name={props.name}/>
        <div className='card-main'>
          <Message text={props.text}/>
        </div>
      </div>
    );
  }

export default Card;  