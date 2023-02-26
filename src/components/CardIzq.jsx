import React from "react";

const CardIzq = () => {
  return <div className="">
    <div className='pt-6 h-36'>
        <div className='mx-5 h-full flex gap-4 md:mx-4 lg:mx-6 2xl:mx-20'>
            <img src="../public/pt2-5.jpg" alt=""
            className='object-cover w-2/4 sm:w-1/4 md:w-2/4' />
            <div className='w-2/4 sm:w-3/5' >
            <a className='font-crimson font-semibold text-sm text-[#2c9995] md:text-xs lg:text-sm' href="">Category</a>
            <h2 className='my-1 font-poppins font-semibold overflow-hidden md:text-xs lg:text-sm xl:text-base'>Alberto Fernández llega a Chaco</h2>
            <p className='font-crimson font-normal text-sm text-gray-400 pt-0 md:text-xs lg:text-sm'>Hora de publicación</p>
            </div>
        </div>
    </div>
  </div>;
};

export default CardIzq;
